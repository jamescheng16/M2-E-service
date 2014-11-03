/**
 * Created by CHENG Xiaojun on 20/10/14.
 */
module("moneyFactory", {
//	setup:function(){alert("setup money individual test");},
//	teardown:function(){alert("teardown money individual test");}
});

test("test construct money",function()
    {
        var moneyFactory = new MoneyFactory();
        var m = moneyFactory.createMoney({
            v:1,
            curr:"EUR"
        });
        ok(m.v==1,"valeur = 1");
        equal(m.curr,"EUR","currency = EUR");
    }
);


test("test construct money <1 ",function()
    {
        var moneyFactory = new MoneyFactory();
        var m = moneyFactory.createMoney({
            v:-1,
            curr:"EUR"
        });
        ok(m.v==-1,"valeur = -1");
        equal(m.curr,"EUR","currency = EUR");
    }
);

test("test construct money not predefine ",1,function()
    {
        var moneyFactory = new MoneyFactory();

        throws(function() {var m = moneyFactory.createMoney({
            v:1,
            curr:"EURZS"
        })
        },CurrNotFound, "Curr not found exception");
    }
);




test("test equals", 1, function()
    {



        var moneyFactory = new MoneyFactory();
        var m1 = moneyFactory.createMoney({
            v:1,
            curr:"EUR"
        });

       var m2 = moneyFactory.createMoney({
            v:1.2,
            curr:"CHF"
        });


        ok(m1.equals(m2),"1 EUR égal à 1.2 CHF");

    }
);
