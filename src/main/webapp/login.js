$(document).ready(function(){
    $("input[name=Login]").change(function(){
         alert($(this).val());

         $.ajax({
               url: "http://localhost:8888/rest/checkLoginExist/check/" + $(this).val(),
               type: "GET",
               dataType: "application/json"
          }).done(function(data){
            if(data)
            {
                    alert("Success");
            }
            else
            {

                alert("Success2");
            }
          });

        })
});