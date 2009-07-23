/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){                
                $("div.round").wrap("<div class='titlebox'></div>");
                $("div.titlebox").prepend("<b class='rtop'><b class='r1'></b>" +
                    "<b class='r2'></b><b class='r3'></b><b class='r4'></b></b>");
                $("div.titlebox").append("<b class='rbottom'><b class='r4'></b>" +
                    "<b class='r3'></b><b class='r2'></b><b class='r1'></b></b>");
            });

