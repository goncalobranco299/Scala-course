package lectures.part2oop

object Enums {

  enum Permissions {
    case READ, WRITE, EXECUTE, NONE

    def openDocument(): Unit =
      if(this == READ)println("opening document...")
      else println("reading not allowed")

  }

  val somePermission: Permissions = Permissions.READ

  // constructor args
  enum PermissionsWithBits(bits: Int) {
    case READ extends PermissionsWithBits(4)
    case WRITE extends PermissionsWithBits(2)
    case EXECUTE extends PermissionsWithBits(1)
    case NONE extends PermissionsWithBits(0)
  }

  object  PermissionsWithBits {
    def fromBits(bits: Int): PermissionsWithBits = // whatever
      PermissionsWithBits.NONE
  }

  // standard API
  val somePermissionOrdinal = somePermission.ordinal
  val allPermissions = PermissionsWithBits.values // array of all possible values of the enum
  val readPermission: Permissions = Permissions.valueOf("Read") // Permissions.

  def main(args: Array[String]): Unit = {
    somePermission.openDocument()
    println(somePermissionOrdinal)
  }
}
