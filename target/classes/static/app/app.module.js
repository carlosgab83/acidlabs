/**
 * Created by Grego on 28-11-16.
 */
(function () {
    'use strict';

    angular.module('app',['naif.base64']).config(['$qProvider', function ($qProvider) {
        $qProvider.errorOnUnhandledRejections(false);
    }]);;


})();