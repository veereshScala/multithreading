
/*
 * this class speaks about the actor model 
 * where actors are objects with threads wrapped with them 
 * instead of methods we call message where there is a box to receive the messge
 threads jump around objects in method calls and it kind of leads to a race condition 
 instead the actor sends a message and keeps working on the object 
 object calls are in the box and wait for the method to complete and calls the second in the message box 
 rules to follow 
 if mutable data then it stays in the actor so they dont share the mutable data so 
 in scala we make use of case class and is suitable for pattern matching 
 actor model is from AKKA
 
 * */

object Actormodel extends App {
  
}