<h1>Link Like</h1>

<g:form name="linkCreateForm" url="[action:'create']">
  Title: <g:textField name="title"/><br/>
  URL: <g:textField name="url"/><br/>
  <input type="submit" value="Add new link"/>
</g:form>
<hr>

<ul>
  <% if(links.size() == 0) { %>
    <li>No links</li>
  <% } else { %>
    <% for(link in links) { %>


      <g:form name="linkCreateForm" url="[action:'amountlike']">
        <li><%= link.title %></li>
        <g:hiddenField name="title" value="${link.title}"/>
        <g:hiddenField name="url" value="${link.url}"/>
        <g:link  controller="${link.url}" name="url" base="http://"><%= link.url %></g:link>

        <input type="submit" value="LIKE"/>
        <%= link.countNumber  %>
      </g:form>


    <% } %> 
  <% } %>
</ul>