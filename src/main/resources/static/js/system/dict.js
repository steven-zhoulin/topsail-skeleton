$(function () {
    $('#dgDict').datagrid({
        onClickRow: function(index, row) {
            var suffix = '?dictId=' + row.id;
            $('#dgDictDetail').datagrid({
                url: 'api/system/dictDetail/search' + suffix
            });
        },
        onClick: function (node) {
            openTab(node.text, node.url);
        }
    });
});

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

function saveDict() {
    $('#fmDict').form('submit', {
        url: url,
        onSubmit: function (param) {
            return $(this).form('validate');
        },
        success: function (result) {
            var result = eval('(' + result + ')');
            if (result.success) {
                $('#dlgDict').dialog('close');
                $('#dgDict').datagrid('reload');
            } else {
                $.messager.show({
                    title: 'Error',
                    msg: result.message
                });
            }
        }
    });
}

function searchDict() {
    var searchContent = $('#searchContent').textbox('getValue');;
    var searchType = $('#searchType').textbox('getValue');;
    var suffix = 'list';
    searchContent = $.trim(searchContent);

    if (searchContent != "") {
        if ('name' == searchType) {
            suffix = 'selectLikeName';
        } else if ('remark' == searchType) {
            suffix = 'selectLikeRemark';
        }
        suffix += '?content=' + searchContent;
    }

    $('#dgDict').datagrid({
        url: 'api/system/dict/' + suffix
    });
}

function addDictDetail() {
    var row = $('#dgDict').datagrid('getSelected');
    $('#dlgDictDetail').dialog('open').dialog('center').dialog('setTitle', '新增');
    $('#fmDictDetail').form('clear');
    $('#dictId').textbox('setValue', row.id);
    url = 'api/system/dictDetail';
}

function editDictDetail() {
    var row = $('#dgDictDetail').datagrid('getSelected');

    if (row) {
        $('#dlgDictDetail').dialog('open').dialog('center').dialog('setTitle', '修改');
        $('#fmDictDetail').form('load', row);
        url = 'api/system/dictDetail/' + row.id + '?_method=put';
    }
}

function deleteDictDetail() {
    var row = $('#dgDictDetail').datagrid('getSelected');
    if (row) {
        $.messager.confirm('信息', '确认删除?', function (r) {
            if (r) {
                $.post('api/system/dictDetail/' + row.id + '?_method=delete', function (result) {
                    if (result.success) {
                        $('#dgDictDetail').datagrid('reload');
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

function saveDictDetail() {
    $('#fmDictDetail').form('submit', {
        url: url,
        onSubmit: function (param) {
            return $(this).form('validate');
        },
        success: function (result) {
            var result = eval('(' + result + ')');
            if (result.success) {
                $('#dlgDictDetail').dialog('close');
                $('#dgDictDetail').datagrid('reload');
            } else {
                $.messager.show({
                    title: 'Error',
                    msg: result.message
                });
            }
        }
    });
}