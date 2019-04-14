function addDict() {
    $('#dlgDict').dialog('open').dialog('center').dialog('setTitle', '新增');
    $('#fmDict').form('clear');
    url = 'api/system/dict';
}

function editDict() {
    var row = $('#dgDict').datagrid('getSelected');

    if (row) {
        $('#dlgDict').dialog('open').dialog('center').dialog('setTitle', '修改');
        $('#fmDict').form('load', row);
        if (row.enabled == '激活') {
            $("#select_id ").val(true);
        } else {
            $("#select_id ").val(false);
        }
        url = 'api/system/dict/' + row.id + '?_method=put';
    }
}

function deleteDict() {
    var row = $('#dgDict').datagrid('getSelected');
    if (row) {
        $.messager.confirm('信息', '确认删除?', function (r) {
            if (r) {
                $.post('api/system/dict/' + row.id + '?_method=delete', function (result) {
                    if (result.success) {
                        $('#dgDict').datagrid('reload');
                    } else {
                        $.messager.show({
                            title: 'Error',
                            msg: result.message
                        });
                    }
                }, 'json');
            }
        });
    }
}

function save() {
    $('#fmDict').form('submit', {
        url: url,
        onSubmit: function (param) {
            return $(this).form('validate');
        },
        success: function (result) {
            var result = eval('(' + result + ')');
            if (result.errorMsg) {
                $.messager.show({
                    title: 'Error',
                    msg: result.errorMsg
                });
            } else {
                $('#dlgDict').dialog('close');		// close the dialog
                $('#dgDict').datagrid('reload');	// reload the user data
            }
        }
    });
}