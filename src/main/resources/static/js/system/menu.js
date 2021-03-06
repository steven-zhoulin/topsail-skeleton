$(function () {
    $('#dgDept').datagrid({
        onClick: function (node) {
            openTab(node.text, node.url);
        }
    });
});


function addDept() {
    $('#dlgDept').dialog('open').dialog('center').dialog('setTitle', '新增');
    $('#fmDept').form('clear');
    $("#enabledId").switchbutton({checked: true});
    url = 'api/system/dept';
}

function editDept() {
    var row = $('#dgDept').datagrid('getSelected');

    if (row) {
        $('#dlgDept').dialog('open').dialog('center').dialog('setTitle', '修改');
        $('#fmDept').form('load', row);
        if (row.enabled) {
            $("#enabledId").switchbutton({checked: true});
        }
        url = 'api/system/dept/' + row.id + '?_method=put';
    }
}

function deleteDept() {
    var row = $('#dgDept').datagrid('getSelected');
    if (row) {
        $.messager.confirm('信息', '确认删除?', function (r) {
            if (r) {
                $.post('api/system/dept/' + row.id + '?_method=delete',

                    function (result) {
                    if (result.code) {
                        $.messager.show({
                            title: '异常',
                            msg: result.message
                        });
                    } else {
                        $('#dgDept').datagrid('reload');
                    }
                }, 'json');
            }
        });
    }
}

function saveDept() {
    $('#fmDept').form('submit', {
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
                $('#dlgDept').dialog('close');
                $('#dgDept').datagrid('reload');
            }
        }
    });
}

function searchDept() {
    var searchContent = $('#searchContent').textbox('getValue');;
    var searchType = $('#searchType').textbox('getValue');;
    var suffix = 'selectLikeName';
    if (searchContent) {
        searchContent = $.trim(searchContent);
    }

    if (searchContent != "") {
        suffix += '?content=' + searchContent + "&enabled=" + searchType;
    } else {
        suffix += "?enabled=" + searchType;
    }

    $('#dgDept').datagrid({
        url: 'api/system/dept/' + suffix
    });
}

function dislayEnabled(value) {
    if (value) {
        return '<span style="color:green">正常</span>'
    } else {
        return '<span style="color:red">禁用</span>'
    }
}