console.log("custom-tool-2")
$(document).ready(function() {
    var currentURL = window.location.href;
    var url = new URL(currentURL);
    var path = url.searchParams.get('path');
      
      $.ajax({
          url: '/bin/getdata',
          type: 'GET',
          data: {path :path },
          success: function(response) {
           
              console.log("Response from servlet:",response);
              displayResponse(response);
          },
          error: function(xhr, status, error) {
              console.error('Request failed. Status:', status);
          }
      });
      $('#deleteButton').click(function(e) {
    

        var assetPath = "/content/dam/example/image.jpg"; 
        $.ajax({
            url: '/bin/remove',
            type: 'POST',
            data: { path:path },
            success: function(response) {
              
                console.log("Asset deleted successfully",response);
            },
            error: function(xhr, status, error) {
                console.error('Failed to delete asset. Status:', status);
            }
        });
    });
});

function displayResponse(response) {
   
    var responseContainer = $('#responseContainer');
    responseContainer.empty();
    $.each(response, function(key, value) {
       
        var listItem = $('<li></li>').text(key + '    : ' + value);
        responseContainer.append(listItem);
    });
}






