(() => {
    let xid = localStorage.getItem("xid");

    if (xid === undefined) {
        xid = null;
    }

    document.getElementsByName("xid").forEach((el) => {
        el.value = xid;
    });
})();