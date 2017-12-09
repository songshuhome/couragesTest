$(function () {
    $("#insertAdmin").validate({
        debug:true,
        submitHandler:function (form) {
            form.submit();//表示手工提交
        },
        rules:{
            aid:{
                required:true
            },
            password:{
                required:true,
                ranglength;[4]-[8]
            }

        }
    })
});