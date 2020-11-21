function toBasket(productClass) {

    let data = {
        "productClass" : productClass
    };

    $.ajax({
        type: "POST",
        url: "/products",
        data: JSON.stringify(data),
        // success: function (response) {
        //     renderTable(response, $('#table'))
        // },
        dataType: "json",
        contentType: "application/json"
    })


}