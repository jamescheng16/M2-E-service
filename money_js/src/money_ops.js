var MoneyOps=function (){
}

MoneyOps.add = function(m1,m2){

    if( m1.getCurrency().toLowerCase() != m2.getCurrency().toLowerCase())
        throw new DevisesIncompatibleExc(m1,m2);


    else
        return new money(m1.getValue() + m2.getValue(), m1.getCurrency());

}


MoneyOps.soustraction = function(m1,m2){

    if(m1.getCurrency().toLowerCase() != m2.getCurrency().toLowerCase())
        throw new DevisesIncompatibleExc(m1,m2);




    if(parseInt( m1.getValue() ) <  parseInt(m2.getValue()))
        throw new SoustractionIncompatibleExc(m1,m2);



        return new money(m1.getValue() - m2.getValue(), m1.getCurrency());

}


