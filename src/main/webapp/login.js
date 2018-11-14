$(document).ready(function(){

    var $but=$('#main2').find("input[type=submit]");

    $("input[name=Login]").on('change', function(){
         $.ajax({
               url: "/rest/checkLoginExist/check/" + $(this).val(),
               type: "GET",
          }).done(function(data){
            if (data)
            {
                $but.prop("disabled", true);
                alert("User with this login already exists");
                console.log($but.val());
            }
            else
            {
                $but.prop("disabled", false);
            }
          })

        })
});