

function upOneImgByAotu(serverURL, pickNode, uploadSuccess) {
    var uploader = WebUploader.create({
        auto: true,
        swf: path_home+'lib/webuploader/0.1.5/Uploader.swf',
        // 文件接收服务端。
        server: serverURL,
        // 选择文件的按钮。可选。
        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
        pick: pickNode,
        // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
        resize: false,
        // 只允许选择图片文件。
        accept: {
            title: 'Images',
            extensions: 'gif,jpg,jpeg,bmp,png',
            mimeTypes: 'image/*'
        }
    });
    // 文件上传成功，给item添加成功class, 用样式标记上传成功。  
    uploader.on('uploadSuccess', function (file, res) {
        uploadSuccess(file, res);
    });
    return uploader;
}




