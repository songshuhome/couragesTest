$(function () {
    $("#insertForm").validate({
        debug:true,
        submitHandler:function (form) {
            form.submit();//表示手工提交
        },
        rules:{
            mid:{
                required:true
            },
            name:{
                required:true

            },
             passwordm:{
               required:true
             },
             grade:{
                required:true

             }

        }
    })
});