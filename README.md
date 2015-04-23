# EasyProperty
Let android application use set/get property easily

NOTICE:
  You application permission should be system permission (android.uid.system),
  and apk should be signed by using your android os key.

HOW TO USE:
  FIRST.
    1. Property property = new Property();
    2. property.Init();
  SECOND.
    ----- using setprop
    |           String PropName = "somthing android property which can modify by system"
    |           String Value    = "the value which you wanna set"
    |           if(property.SetProp(PropName,Value))
    |           {
    |               //setprop ok!
    |           }
    |           else
    |           {
    |              //setprop fail!
    |           }
    ----- using getprop
    |           String PropName = "somthing android property which can modify by system"
    |           String Value    = null;
    |           Value = property.GetProp(PropName);
