/* 
    html 弹出框中的内容
    url Object
        base 最终提交的url
        edit 编辑url
        type 提交方式
        control 'edit'
        data 要传递的数据

*/
$.extend({
    modal: function (opt) {
        var html = opt.html
        var url = opt.url.base
        var editUrl = opt.url.edit
        var control = opt.control
        var data = opt.data
        var userId = opt.userId
        var id = opt.id
        var $modal = $(`
            <div class="modal fade in show" tabindex="-1" role="dialog">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-body">
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default modal-close" data-dismiss="modal">关闭</button>
                            <button type="button" class="btn btn-primary submit">保存</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->
        `)
        $body = $modal.find('.modal-body')
        $body.html(html)
        $('body').append($modal)
        $form = $modal.find('form')
        $submit = $modal.find('.submit')

        if (control === 'edit') {
            $.ajax({
                url: editUrl, 
                data: data,
                success: function (res) {
                    console.log(res)
                    for (var key in res) {
                        $('[name= "' + key + '"]').val(res[key])
                    }
                }
            })
        }
        $modal.find('.modal-close').on('click', function () {
            $modal.remove()
        })
        
        function getFormData($form) {
    var unindexed_array = $form.serializeArray();
    var indexed_array = {};

    $.map(unindexed_array, function (n, i) {
      indexed_array[n['name']] = n['value'];
    });
     
    
    return indexed_array;
}
        
        $submit.on('click', function () {
        	console.log(add)
        	var da = getFormData($form);
            if(add=="providerAdd"){
            	da.userId = userId
        	}
            if(update=="providerupdate"){
            	da.userId = userId
            	da.id =id
        	}
            if(add=="goodsAdd"){
            	da.userId = userId
        	}
            if(update=="goodsupdate"){
            	da.userId = userId
            	da.id =id
        	}
        	if(add=="purchaseAdd"){
        		da.goodsId = $('.spmc').val();
        		da.providerId = $('.gysmc').val();
        		da.userId = userId
        	}
        	
        	
        	var dat = JSON.stringify(da);
        	
        	console.log(dat)
            $.ajax({
                type: 'post',
                url: url,
                contentType: 'application/json',
                dataType: 'json',
                data: dat,
                success: function(res) {
                	console.log(userId)
                	 console.log('成功')
                	 window.location.reload()
                     $modal.remove()
                }
            });
        })

    
    }
})

/* $.fn.modal = function (opt) {
    

    return this.each(function () {
        $(this).addEventListener('click', showModal)
    })
 
    


    
} */