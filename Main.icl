package com::github::industrialcraft::icltest;

#!extends(Parent1)
#!implements(Parent2)
int i;
static bool& end#;
protected void check(){
    if(i > 5)
        return (i+end);
    a.ahoj();
    return 0;
}