# WarpScript Kotlin DSL

This project corresponds to a first iteration of how building a WarpScript DSL.
To simplify this process for future iteration at Cityzen Data, we will work on each function signature.
As soon as will release it, everyone will be able to build his own DSL, to build a WarpScript syntax matching his needs.

This DSL includes almost all WarpScript documented function to be used using a Kotlin method syntax.

This project is only in an alpha phase, all the code can suddenly be change.

## Getting started

Just build and include this project (To be updated)

## Project structure

This project include a WarpScript class that contains all WarpScript methods and two static methods:
  - A WarpScript generator 
  - An execute function
  
## How to use this DSL

Create your own Main Kotlin class

```
//
// Main class to execute WarpScript code
//

fun main(args: Array<String>) {
}
```

Then open a WarpScript generator

```
//
// Main class to execute WarpScript code
//

fun main(args: Array<String>) {

    //
    // Open WarpScript generator
    //
    
    var tmp = WarpScript.generate {
        
        // Apply WarpScript function now
        now()
    }
}
```

When opening a generator inside { } you can put all WarpScript methods wanted with a Kotlin syntax.
Here as an example now corresponds to the WarpScript NOW function.

This create a WarpScript element, using the function render or toString on it will gives the WarpScript code generated as output.

Then to simply execute and print the WarpScript result, it's possible to use the exec function like below.

```
//
// Main class to execute WarpScript code
//

fun main(args: Array<String>) {

    //
    // Open WarpScript generator
    //
    
    var tmp = WarpScript.generate {
        
        // Apply WarpScript function now
        now()
    }
    
    var output = WarpScript.exec(tmp, "http://127.0.0.1:8080/api/v0/exec")

    println(output.toJsonString(true))
}
```

The exec function takes the WarpScript element as well as the URL string corresponding to the Warp 10 instance.
It gives as output a JsonArray corresponding to the stack result.

You will find this code and other example in the package samples:

- HelloKotlinDSL: this example.
- CompleteExample: A complete example that can run on any Warp 10 instance, showing use of the Bucketize and Map framework.
- ChainCommands: A chaining commands example that can **NOT** run on a Warp 10 instance. It shows several syntax as fetch, reduce, bucketize and so on.

You will also find other examples in the Test repository.

## RoadMap and features to add

- Apply refactoring
- Macro function refactoring
- Use WarpScript correct generated signature
- Null as possible default value

## Contribution

To be done, but any idea or contribution will be welcomed