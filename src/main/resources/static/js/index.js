(() => {
    let element = document.getElementById("xid");

    if (null !== element) {
        element.value = localStorage.getItem("xid");
    }
})();