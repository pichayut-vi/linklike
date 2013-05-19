package linklike



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(LinkController)
@Mock([Link])
class LinkControllerTests {
	void testCreateNewLink() {
       def link = new Link(	title: 'GOOGLE',
       							url: 'www.google.com')
       assert link != null
    }

    void testDefaultProperties() {
       def link = new Link(	title: 'GOOGLE',
       							url: 'www.google.com')
       assertEquals 0, link.countNumber
    }

 

    void testCreateRepeatTitleURL()
    {
    	params.title = 'facebook'
    	params.url = 'www.facebook.com'

    	controller.create()

    	assert Link.count == 1
    }

    void testLikeLink()
    {
    	mockDomain(Link,
    		[ [title:'ant',url:'bird'],
    		  [title:'cat',url:'dog'],
    		  [title:'egg',url:'fish'],
    		  [title:'good',url:'ice'] ])
      def ant = "ant"
      def bird = "bird"

    	controller.amountlike(ant,bird)	

      assert Link.get(1).countNumber == 1
      assert Link.get(2).countNumber == 0
      assert Link.get(3).countNumber == 0
    }
}
 