/**
 * Created by CHENG Xiaojun on 03/11/14.
 */

/**
 * this is the class for test alert.
 */
module("calc", {
//	setup:function(){alert("setup moneyOps individual test");},
//	teardown:function(){alert("teardown moneyOps individual test");}
});
test("not supported operation ", function()
    {
        //overwrite the alert function to test
        window.alert = function ( s ) {
            document.getElementById('qunit-fixture').innerHTML = s;
        }


        var fixture="";
        fixture+=("<form id='form0'>");
        fixture+=("<input type='text' id='v1' name='v1' value='1'/>");
        fixture+=("<input type='text' id='c1' name='c1' value='EU'/>");
        fixture+=("<input type='text' id='v2' name='v2' value='2'/>");
        fixture+=("<input type='text' id='c2' name='c2' value='EU'/>");
        fixture+=("<input type='text' id='ops' name='ops' value='MUL'/>");
        fixture+=("</form>");


        var fixtureNode=document.getElementById("qunit-fixture");
        fixtureNode.innerHTML=fixture;


        var c=new calc();
        c.computeResult(document.getElementById('form0'));


        strictEqual( document.getElementById('qunit-fixture').innerHTML, 'Unsupported operation',"ok" );

    }
);


test("test_moins_1", function()
    {
        //overwrite the alert function to test
        window.alert = function ( s ) {
            document.getElementById('qunit-fixture').innerHTML = s;
        }


        var fixture="";
        fixture+=("<form id='form0'>");
        fixture+=("<input type='text' id='v1' name='v1' value='-1'/>");
        fixture+=("<input type='text' id='c1' name='c1' value='EU'/>");
        fixture+=("<input type='text' id='v2' name='v2' value='2'/>");
        fixture+=("<input type='text' id='c2' name='c2' value='EU'/>");
        fixture+=("<input type='text' id='ops' name='ops' value='ADD'/>");
        fixture+=("</form>");


        var fixtureNode=document.getElementById("qunit-fixture");
        fixtureNode.innerHTML=fixture;


        var c=new calc();
        c.computeResult(document.getElementById('form0'));


        strictEqual( document.getElementById('qunit-fixture').innerHTML, 'Money cant be less then 0',"ok" );

    }
);

test("test_different_devise", function()
    {
        //overwrite the alert function to test
        window.alert = function ( s ) {
            document.getElementById('qunit-fixture').innerHTML = s;
        }


        var fixture="";
        fixture+=("<form id='form0'>");
        fixture+=("<input type='text' id='v1' name='v1' value='2'/>");
        fixture+=("<input type='text' id='c1' name='c1' value='CH'/>");
        fixture+=("<input type='text' id='v2' name='v2' value='2'/>");
        fixture+=("<input type='text' id='c2' name='c2' value='EU'/>");
        fixture+=("<input type='text' id='ops' name='ops' value='ADD'/>");
        fixture+=("</form>");


        var fixtureNode=document.getElementById("qunit-fixture");
        fixtureNode.innerHTML=fixture;


        var c=new calc();
        c.computeResult(document.getElementById('form0'));


        strictEqual( document.getElementById('qunit-fixture').innerHTML, 'Not the same currency',"ok" );

    }
);
