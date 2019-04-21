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
        },
        onDblClickCell: function(node) {
            editDict();
        }
    });

    $('#dgDictDetail').datagrid({
        onDblClickCell: function(node) {
            editDictDetail();
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
                $.post('api/system/dict/' + row.id + '?_method=delete',

                    function (result) {
                    if (result.code) {
                        $.messager.show({
                            title: '异常',
                            msg: result.message
                        });
                    } else {
                        $('#dgDict').datagrid('reload');
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
            if (result.error) {
                $.messager.show({
                    title: 'Error',
                    msg: result.error
                });
            } else {
                $('#dlgDict').dialog('close');
                $('#dgDict').datagrid('reload');
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
                    if (result.code) {
                        $.messager.show({
                            title: '异常',
                            msg: result.message
                        });
                    } else {
                        $('#dgDictDetail').datagrid('reload');
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
            if (result.error) {
                $.messager.show({
                    title: 'Error',
                    msg: result.error
                });
            } else {
                $('#dlgDictDetail').dialog('close');
                $('#dgDictDetail').datagrid('reload');
            }
        }
    });
}