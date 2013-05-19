package linklike

class LinkController {

    def index() { 
        def links = Link.findAll()
        [ links: links ]
    }

    def create() {
        def links = Link.findAll()
        def temp = 0
        def link = new Link(title: params.title, url: params.url)
        for (i in links)
        {
            if(i.title == link.title & i.url == link.url)
            {
                temp++                
            }
        }
        if(temp == 0)
        {
            link.save()
        } 
        redirect(action: "index")
    }

    def amountlike(String title,String url){
        def links = Link.findAll()
        for (i in links)
        {
                if(i.title == title & i.url == url){
                i.countNumber += 1

                
            }
        }
          redirect(action: "index")

    }

   

}