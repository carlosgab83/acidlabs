/**
 * Created by Grego on 28-11-16.
 */
(function () {
    'use strict';

    angular
        .module('app')
        .controller('UsersController', UsersController);

    UsersController.$inject = ['$http'];
    
    function UsersController($http) {
        var vm = this;


        vm.data = {};
        vm.user={username:'',image:''};
        vm.users = [];
        vm.getAll = getAll;
        vm.createUser = createUser;
        vm.loadData = loadData;


        function getAll(){
            var url = "/all";
            var usersPromise = $http.get(url);
            usersPromise.then(function (response) {
                vm.users = response.data;
            });

        }

        function loadData() {

            var f = document.getElementById('file').files[0],
                r = new FileReader();
            r.onloadend = function(e){
                if(e.target.result != null) {
                    vm.data.b64 = e.target.result;
                    vm.user.image = vm.data.b64.replace(/^data:image\/(png|jpg);base64,/, "");
                    console.log(vm.data.b64.replace(/^data:image\/(png|jpg);base64,/, ""));
                }
            }
            if(f != null)
                 r.readAsDataURL(f);

            createUser();


        }

        function createUser(){

            var url = "/users"
            $http.post(url, vm.user).then(function(response){
                vm.users = response.data;

            });
        }

    }


})();
