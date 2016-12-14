"use strict";
var InfoPagination = (function () {
    function InfoPagination(numOfPages, actualPage, pageSize, actualPageSize, totalElements, last, first) {
        this.numOfPages = numOfPages;
        this.actualPage = actualPage;
        this.pageSize = pageSize;
        this.actualPageSize = actualPageSize;
        this.totalElements = totalElements;
        this.last = last;
        this.first = first;
    }
    return InfoPagination;
}());
exports.InfoPagination = InfoPagination;
//# sourceMappingURL=infoPagination.js.map