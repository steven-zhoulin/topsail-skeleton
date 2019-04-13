$(function () {
    $('#menu-tree').tree({
        onClick: function (node) {
            openTab(node.text, node.url);
        }
    });
});

function addTab(url, text, iconCls) {
    var content = "<iframe frameborder='0' scrolling='auto' style='width:100%;height:100%' src='/views/" + url + "'></iframe>";
    $("#tabs").tabs("add", {
        title: text,
        iconCls: iconCls,
        closable: true,
        content: content
    });
}

function openTab(text, url, iconCls) {
    if ($("#tabs").tabs("exists", text)) {
        $("#tabs").tabs("close", text);
        addTab(url, text, iconCls);
        $("#tabs").tabs("select", text);
    } else {
        addTab(url, text, iconCls);
    }
}

function logout() {
    $.messager
        .confirm(
            "系统提示",
            "您确定要退出系统吗",
            function (r) {
                if (r) {
                    clearCookie();
                }
            });
}