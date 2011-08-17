function menuItemOver(item) {
    item.className = "menu-item-over";
}
function menuItemOut(item) {
    item.className = "menu-item";
}
function linkItemOver(item) {
    item.className = "link-over";
}
function linkItemOut(item) {
    item.className = "link";
}
function menuItemClick(url) {
    location.href = url;
}
function checkFormFields(form) {

}
function nav(o) {
    window.open(o.url, o.tipo);
}
function sendForm(form) {
    var btn = Ext.get(form);
    var form = btn.findParent("form", document.body, true);
    var formItems = form.query("[class=form_item]");
    var isFormReady = true;
    var params = {};
    Ext.each(formItems, function (item) {
        var validator = Ext.getDom("v_" + item.id);
        switch (item.tagName) {
            case 'SELECT':
                if (item.selectedIndex == 0) {
                    validator.style.visibility = "visible";
                    isFormReady = false;
                } else {
                    params[item.id] = item.selectedIndex;
                }
                break;
            case 'INPUT':
                if (item.type == "text") {
                    if (item.value == "") {
                        validator.style.visibility = "visible";
                        isFormReady = false;
                    } else {
                        params[item.id] = item.value;
                    }
                }
                break;
        }
    });
    if (isFormReady) {
        params = Ext.urlEncode(params);
        window.open("Informe-Resultados.aspx?" + params, "_blank");
    }
}

function OpenChild() {
    var winSettings = "center:yes;resizable:no;dialogHeight:300px";
    var myArgs = window.showModalDialog("/Alta.aspx", null, winSettings);
}