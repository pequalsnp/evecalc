package slick
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = scala.slick.driver.H2Driver
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: scala.slick.driver.JdbcProfile
  import profile.simple._
  import scala.slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import scala.slick.jdbc.{GetResult => GR}
  
  /** DDL for all tables. Call .create to execute. */
  lazy val ddl = Items.ddl
  
  /** Entity class storing rows of table Items
   *  @param id Database column ID DBType(INTEGER), PrimaryKey
   *  @param name Database column NAME DBType(VARCHAR), Length(255,true)
   *  @param categoryid Database column CATEGORYID DBType(INTEGER)
   *  @param categoryname Database column CATEGORYNAME DBType(VARCHAR), Length(255,true)
   *  @param marketgroupid Database column MARKETGROUPID DBType(INTEGER) */
  case class ItemsRow(id: Int, name: Option[String], categoryid: Option[Int], categoryname: Option[String], marketgroupid: Option[Int])
  /** GetResult implicit for fetching ItemsRow objects using plain SQL queries */
  implicit def GetResultItemsRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[Option[Int]]): GR[ItemsRow] = GR{
    prs => import prs._
    ItemsRow.tupled((<<[Int], <<?[String], <<?[Int], <<?[String], <<?[Int]))
  }
  /** Table description of table ITEMS. Objects of this class serve as prototypes for rows in queries. */
  class Items(_tableTag: Tag) extends Table[ItemsRow](_tableTag, "ITEMS") {
    def * = (id, name, categoryid, categoryname, marketgroupid) <> (ItemsRow.tupled, ItemsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, name, categoryid, categoryname, marketgroupid).shaped.<>({r=>import r._; _1.map(_=> ItemsRow.tupled((_1.get, _2, _3, _4, _5)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column ID DBType(INTEGER), PrimaryKey */
    val id: Column[Int] = column[Int]("ID", O.PrimaryKey)
    /** Database column NAME DBType(VARCHAR), Length(255,true) */
    val name: Column[Option[String]] = column[Option[String]]("NAME", O.Length(255,varying=true))
    /** Database column CATEGORYID DBType(INTEGER) */
    val categoryid: Column[Option[Int]] = column[Option[Int]]("CATEGORYID")
    /** Database column CATEGORYNAME DBType(VARCHAR), Length(255,true) */
    val categoryname: Column[Option[String]] = column[Option[String]]("CATEGORYNAME", O.Length(255,varying=true))
    /** Database column MARKETGROUPID DBType(INTEGER) */
    val marketgroupid: Column[Option[Int]] = column[Option[Int]]("MARKETGROUPID")
  }
  /** Collection-like TableQuery object for table Items */
  lazy val Items = new TableQuery(tag => new Items(tag))
}