"use strict";
var router_1 = require('@angular/router');
var libros_list_component_1 = require("./main/app/components/list/libros-list.component");
var libros_detail_component_1 = require("./main/app/components/detail/libros-detail.component");
var libro_add_component_1 = require("./main/app/components/add/libro-add.component");
var libro_edit_component_1 = require("./main/app/components/edit/libro-edit.component");
var appRoutes = [
    {
        path: '',
        redirectTo: '/',
        pathMatch: 'full'
    },
    { path: "", component: libros_list_component_1.LibrosListComponent },
    { path: "libro/:id", component: libros_detail_component_1.LibrosDetailComponent },
    { path: "crear-libro", component: libro_add_component_1.LibroAddComponent },
    { path: "editar-libro/:id", component: libro_edit_component_1.LibroEditComponent },
    { path: "que-leo-hoy/:random", component: libros_detail_component_1.LibrosDetailComponent },
];
exports.appRoutingProviders = [];
exports.routing = router_1.RouterModule.forRoot(appRoutes);
//# sourceMappingURL=app.routing.js.map