def addName(x:String) = x + ",ok"

def say(x:String) = x + ",please say: \"Hello guys \""
//f(x) compose g(x) => f(g(x))
val composition = addName _ compose say _
composition("Alex")

//f(x) andThen g(x) => g(f(x)
val andThen = addName _ andThen say _
andThen("Alex")