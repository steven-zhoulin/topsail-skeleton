$(function () {
    $('#dgJob').datagrid({
        onClick: function (node) {
            openTab(node.text, node.url);
        },
        onDblClickCell: function(node) {
            editJob();
        }
    });
});


function addJob() {
    $('#dlgJob').dialog('open').dialog('center').dialog('setTitle', '新增');
    $('#fmJob').form('clear');
    $("#enabledId").switchbutton({checked: true});
    url = 'api/system/job';
}

function editJob() {
    var row = $('#dgJob').datagrid('getSelected');

    if (row) {
        $('#dlgJob').dialog('open').dialog('center').dialog('setTitle', '修改');
        $('#fmJob').form('load', row);
        if (row.enabled) {
            $("#enabledId").switchbutton({checked: true});
        }
        url = 'api/system/job/' + row.id + '?_method=put';
    }
}

function deleteJob() {
    var row = $('#dgJob').datagrid('getSelected');
    if (row) {
        $.messager.confirm('信息', '确认删除?', function (r) {
            if (r) {
                $.post('api/system/job/' + row.id + '?_method=delete',

                    function (result) {
                    if (result.code) {
                        $.messager.show({
                            title: '异常',
                            msg: result.message
                        });
                    } else {
                        $('#dgJob').datagrid('reload');
                    }
                }, 'json');
            }
        });
    }
}

function saveJob() {
    $('#fmJob').form('submit', {
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
                $('#dlgJob').dialog('close');
                $('#dgJob').datagrid('reload');
            }
        }
    });
}

function searchJob() {
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

    $('#dgJob').datagrid({
        url: 'api/system/job/' + suffix
    });
}

function dislayEnabled(value) {
    if (value) {
        return '<span style="color:green">正常</span>'
    } else {
        return '<span style="color:red">禁用</span>'
    }
}