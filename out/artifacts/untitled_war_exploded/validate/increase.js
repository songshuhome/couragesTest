$(function () {
    $("#increaseForm").validate({
        debug:true,
        submitHandler:function (form) {
            form.submit();//表示手工提交
        },
        rules:{
            sid:{
                required:true
            },
            grade:{
                required:true,
                rangelength:[1,2]

            }

        }
    })
});