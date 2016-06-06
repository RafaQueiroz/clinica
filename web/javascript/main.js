/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

    function determinaTipo(tipoNum){
        switch(tipoNum){
            case 3: 
                return 'adm';
                break;
            case 4:
                return 'med';
                break;
            default:
                return 'usr';
                break;
        }
    }

    function exibeMenu(tipo){

       $('li').each(function(i){

            if($(this).hasClass(tipo)){
                $(this).css('display','inline-block');
            }
       });           

    }