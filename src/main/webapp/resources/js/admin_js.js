/**
 * UPLOAD PRODUCT IMAGE
 */
var image = null;
var id_input_img = null;
$('.img_product').click(function () {
    $('#fileUpload').click();
    image = $(this);
    id_input_img = $(this).attr('id');
});

$(function () {
    $('#fileUpload').change(function (e) {
        e.preventDefault();

        var form = $('#formUpload')[0];
        var formData = new FormData(form);
        $.ajax({
            url: '/uploadpath',
            type: 'POST',
            enctype: 'multipart/form-data',
            data: formData,
            contentType: false,
            processData: false,
            success: function (result) {
                image.attr('src', result);
                // $('#input_image_detail').val(result);
                setValImg(id_input_img, result);
            },
            error: function (error) {
                alert("Lỗi hệ thống ");
            }
        });
    });
});

function setValImg(id_input, result) {
    if (id_input == 'img_main') {
        $('#input_image').val(result);
    } else {
        var img1 = $('#img_detail_1').attr('src');
        var img2 = $('#img_detail_2').attr('src');
        var img3 = $('#img_detail_3').attr('src');

        var img = img1 + "~" + img2 + "~" + img3;
        $('#input_image_detail').val(img.replace('~~', "~"));
    }
}
