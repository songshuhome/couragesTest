$(function () {
    $("#lessonForm").validate({
        debug:true,
        submitHandler:function (form) {
            form.submit();//表示手工提交
        },
        rules:{
            stept:{
                required:true
            },
            lesson:{
                required:true
            }

        }
    })
});