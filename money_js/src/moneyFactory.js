/**
 * Created by CHENG Xiaojun on 20/10/14.
 */
function moneyEUR(options){
    this.v = options.v;
    this.curr = options.curr;
}

function moneyCHF(options){
    this.v = options.v / 1.2;
    this.curr = options.curr;
}


function MoneyFactory(){}
    //default money type
MoneyFactory.prototype.curr = moneyEUR;

    MoneyFactory.prototype.createMoney = function (options){
        switch  (options.curr) {
            case "EUR":
                this.curr = moneyEUR;
                break;
            case "CHF":
                this.curr = moneyCHF;
                break;
            default:
                throw new CurrNotFound();
        }

        return new this.curr(options);

    };

//moneyEUR.prototype = new money(this.v, this.curr);
//moneyCHF.prototype = new money(this.v, this.curr);




moneyEUR.prototype.getCurrency=
    function () {
        return this.curr;
    };

moneyEUR.prototype.getValue=
    function () {
        return this.v;
    };

moneyEUR.prototype.equals=
    function (otherM) {
        return (otherM.getValue()==this.getValue()) ;
    };

moneyEUR.prototype.toString=
    function () {
        return this.getValue()+" ("+this.getCurrency()+")" ;
    };

moneyCHF.prototype.getCurrency=
    function () {
        return this.curr;
    };

moneyCHF.prototype.getValue=
    function () {
        return this.v;
    };

moneyCHF.prototype.equals=
    function (otherM) {
        return (otherM.getValue()==this.getValue() ) ;
    };

moneyCHF.prototype.toString=
    function () {
        return this.getValue()+" ("+this.getCurrency()+")" ;
    };

