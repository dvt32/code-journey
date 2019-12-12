(
    function() {
        var app = angular.module("ContactApp");

        app.service(
            "AppDataServiceSvc", 
            function(AppNameSvc) {
                this.name = AppNameSvc;
                this.author = "dvt32";
                this.builtDate = new Date().toString();
            }
        );
    }
)();