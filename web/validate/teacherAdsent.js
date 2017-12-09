$(function () {
    $("#absentForm").validate({
        debug:true,
        submitHandler:function (form) {
            form.submit();//表示手工提交
        },
        rules:{
            mark:{
                required:true
            }

        }
    })
});