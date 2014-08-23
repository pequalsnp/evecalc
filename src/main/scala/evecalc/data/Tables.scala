package evecalc.data
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = com.typesafe.slick.driver.ms.SQLServerDriver
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: scala.slick.driver.JdbcProfile
  import profile.simple._
  import scala.slick.model.ForeignKeyAction
  import scala.slick.collection.heterogenous._
  import scala.slick.collection.heterogenous.syntax._
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import scala.slick.jdbc.{GetResult => GR}
  
  /** DDL for all tables. Call .create to execute. */
  lazy val ddl = Agtagents.ddl ++ Agtagenttypes.ddl ++ Agtresearchagents.ddl ++ Chrancestries.ddl ++ Chrattributes.ddl ++ Chrbloodlines.ddl ++ Chrfactions.ddl ++ Chrraces.ddl ++ Crpactivities.ddl ++ Crpnpccorporationdivisions.ddl ++ Crpnpccorporationresearchfields.ddl ++ Crpnpccorporations.ddl ++ Crpnpccorporationtrades.ddl ++ Crpnpcdivisions.ddl ++ Dgmattributecategories.ddl ++ Dgmattributetypes.ddl ++ Dgmeffects.ddl ++ Dgmtypeattributes.ddl ++ Dgmtypeeffects.ddl ++ Eveunits.ddl ++ Invcategories.ddl ++ Invcontrabandtypes.ddl ++ Invcontroltowerresourcepurposes.ddl ++ Invcontroltowerresources.ddl ++ Invflags.ddl ++ Invgroups.ddl ++ Invitems.ddl ++ Invmarketgroups.ddl ++ Invmetagroups.ddl ++ Invmetatypes.ddl ++ Invnames.ddl ++ Invpositions.ddl ++ Invtypematerials.ddl ++ Invtypereactions.ddl ++ Invtypes.ddl ++ Invuniquenames.ddl ++ Mapuniverse.ddl ++ Planetschematics.ddl ++ Planetschematicspinmap.ddl ++ Planetschematicstypemap.ddl ++ Ramactivities.ddl ++ Ramassemblylinestations.ddl ++ Ramassemblylinetypedetailpercategory.ddl ++ Ramassemblylinetypedetailpergroup.ddl ++ Ramassemblylinetypes.ddl ++ Raminstallationtypecontents.ddl ++ Staoperations.ddl ++ Staoperationservices.ddl ++ Staservices.ddl ++ Stastations.ddl ++ Stastationtypes.ddl ++ TraceXeActionMap.ddl ++ TraceXeEventMap.ddl ++ Translationtables.ddl ++ Trntranslationcolumns.ddl ++ Trntranslationlanguages.ddl ++ Trntranslations.ddl ++ Warcombatzones.ddl ++ Warcombatzonesystems.ddl
  
  /** Entity class storing rows of table Agtagents
   *  @param agentid Database column agentID DBType(int), PrimaryKey
   *  @param divisionid Database column divisionID DBType(tinyint)
   *  @param corporationid Database column corporationID DBType(int)
   *  @param locationid Database column locationID DBType(int)
   *  @param level Database column level DBType(tinyint)
   *  @param quality Database column quality DBType(smallint)
   *  @param agenttypeid Database column agentTypeID DBType(int)
   *  @param islocator Database column isLocator DBType(bit) */
  case class AgtagentsRow(agentid: Int, divisionid: Option[Byte], corporationid: Option[Int], locationid: Option[Int], level: Option[Byte], quality: Option[Short], agenttypeid: Option[Int], islocator: Option[Boolean])
  /** GetResult implicit for fetching AgtagentsRow objects using plain SQL queries */
  implicit def GetResultAgtagentsRow(implicit e0: GR[Int], e1: GR[Option[Byte]], e2: GR[Option[Int]], e3: GR[Option[Short]], e4: GR[Option[Boolean]]): GR[AgtagentsRow] = GR{
    prs => import prs._
    AgtagentsRow.tupled((<<[Int], <<?[Byte], <<?[Int], <<?[Int], <<?[Byte], <<?[Short], <<?[Int], <<?[Boolean]))
  }
  /** Table description of table agtAgents. Objects of this class serve as prototypes for rows in queries. */
  class Agtagents(_tableTag: Tag) extends Table[AgtagentsRow](_tableTag, Some("dbo"), "agtAgents") {
    def * = (agentid, divisionid, corporationid, locationid, level, quality, agenttypeid, islocator) <> (AgtagentsRow.tupled, AgtagentsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (agentid.?, divisionid, corporationid, locationid, level, quality, agenttypeid, islocator).shaped.<>({r=>import r._; _1.map(_=> AgtagentsRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column agentID DBType(int), PrimaryKey */
    val agentid: Column[Int] = column[Int]("agentID", O.PrimaryKey)
    /** Database column divisionID DBType(tinyint) */
    val divisionid: Column[Option[Byte]] = column[Option[Byte]]("divisionID")
    /** Database column corporationID DBType(int) */
    val corporationid: Column[Option[Int]] = column[Option[Int]]("corporationID")
    /** Database column locationID DBType(int) */
    val locationid: Column[Option[Int]] = column[Option[Int]]("locationID")
    /** Database column level DBType(tinyint) */
    val level: Column[Option[Byte]] = column[Option[Byte]]("level")
    /** Database column quality DBType(smallint) */
    val quality: Column[Option[Short]] = column[Option[Short]]("quality")
    /** Database column agentTypeID DBType(int) */
    val agenttypeid: Column[Option[Int]] = column[Option[Int]]("agentTypeID")
    /** Database column isLocator DBType(bit) */
    val islocator: Column[Option[Boolean]] = column[Option[Boolean]]("isLocator")
    
    /** Index over (corporationid) (database name agtAgents_IX_corporation) */
    val index1 = index("agtAgents_IX_corporation", corporationid)
    /** Index over (locationid) (database name agtAgents_IX_station) */
    val index2 = index("agtAgents_IX_station", locationid)
  }
  /** Collection-like TableQuery object for table Agtagents */
  lazy val Agtagents = new TableQuery(tag => new Agtagents(tag))
  
  /** Entity class storing rows of table Agtagenttypes
   *  @param agenttypeid Database column agentTypeID DBType(int), PrimaryKey
   *  @param agenttype Database column agentType DBType(varchar), Length(50,true) */
  case class AgtagenttypesRow(agenttypeid: Int, agenttype: Option[String])
  /** GetResult implicit for fetching AgtagenttypesRow objects using plain SQL queries */
  implicit def GetResultAgtagenttypesRow(implicit e0: GR[Int], e1: GR[Option[String]]): GR[AgtagenttypesRow] = GR{
    prs => import prs._
    AgtagenttypesRow.tupled((<<[Int], <<?[String]))
  }
  /** Table description of table agtAgentTypes. Objects of this class serve as prototypes for rows in queries. */
  class Agtagenttypes(_tableTag: Tag) extends Table[AgtagenttypesRow](_tableTag, Some("dbo"), "agtAgentTypes") {
    def * = (agenttypeid, agenttype) <> (AgtagenttypesRow.tupled, AgtagenttypesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (agenttypeid.?, agenttype).shaped.<>({r=>import r._; _1.map(_=> AgtagenttypesRow.tupled((_1.get, _2)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column agentTypeID DBType(int), PrimaryKey */
    val agenttypeid: Column[Int] = column[Int]("agentTypeID", O.PrimaryKey)
    /** Database column agentType DBType(varchar), Length(50,true) */
    val agenttype: Column[Option[String]] = column[Option[String]]("agentType", O.Length(50,varying=true))
  }
  /** Collection-like TableQuery object for table Agtagenttypes */
  lazy val Agtagenttypes = new TableQuery(tag => new Agtagenttypes(tag))
  
  /** Entity class storing rows of table Agtresearchagents
   *  @param agentid Database column agentID DBType(int)
   *  @param typeid Database column typeID DBType(int) */
  case class AgtresearchagentsRow(agentid: Int, typeid: Int)
  /** GetResult implicit for fetching AgtresearchagentsRow objects using plain SQL queries */
  implicit def GetResultAgtresearchagentsRow(implicit e0: GR[Int]): GR[AgtresearchagentsRow] = GR{
    prs => import prs._
    AgtresearchagentsRow.tupled((<<[Int], <<[Int]))
  }
  /** Table description of table agtResearchAgents. Objects of this class serve as prototypes for rows in queries. */
  class Agtresearchagents(_tableTag: Tag) extends Table[AgtresearchagentsRow](_tableTag, Some("dbo"), "agtResearchAgents") {
    def * = (agentid, typeid) <> (AgtresearchagentsRow.tupled, AgtresearchagentsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (agentid.?, typeid.?).shaped.<>({r=>import r._; _1.map(_=> AgtresearchagentsRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column agentID DBType(int) */
    val agentid: Column[Int] = column[Int]("agentID")
    /** Database column typeID DBType(int) */
    val typeid: Column[Int] = column[Int]("typeID")
    
    /** Primary key of Agtresearchagents (database name agtResearchAgents_PK) */
    val pk = primaryKey("agtResearchAgents_PK", (agentid, typeid))
    
    /** Index over (typeid) (database name agtResearchAgents_IX_type) */
    val index1 = index("agtResearchAgents_IX_type", typeid)
  }
  /** Collection-like TableQuery object for table Agtresearchagents */
  lazy val Agtresearchagents = new TableQuery(tag => new Agtresearchagents(tag))
  
  /** Entity class storing rows of table Chrancestries
   *  @param ancestryid Database column ancestryID DBType(tinyint), PrimaryKey
   *  @param ancestryname Database column ancestryName DBType(nvarchar), Length(100,true)
   *  @param bloodlineid Database column bloodlineID DBType(tinyint)
   *  @param description Database column description DBType(nvarchar), Length(1000,true)
   *  @param perception Database column perception DBType(tinyint)
   *  @param willpower Database column willpower DBType(tinyint)
   *  @param charisma Database column charisma DBType(tinyint)
   *  @param memory Database column memory DBType(tinyint)
   *  @param intelligence Database column intelligence DBType(tinyint)
   *  @param iconid Database column iconID DBType(int)
   *  @param shortdescription Database column shortDescription DBType(nvarchar), Length(500,true) */
  case class ChrancestriesRow(ancestryid: Byte, ancestryname: Option[String], bloodlineid: Option[Byte], description: Option[String], perception: Option[Byte], willpower: Option[Byte], charisma: Option[Byte], memory: Option[Byte], intelligence: Option[Byte], iconid: Option[Int], shortdescription: Option[String])
  /** GetResult implicit for fetching ChrancestriesRow objects using plain SQL queries */
  implicit def GetResultChrancestriesRow(implicit e0: GR[Byte], e1: GR[Option[String]], e2: GR[Option[Byte]], e3: GR[Option[Int]]): GR[ChrancestriesRow] = GR{
    prs => import prs._
    ChrancestriesRow.tupled((<<[Byte], <<?[String], <<?[Byte], <<?[String], <<?[Byte], <<?[Byte], <<?[Byte], <<?[Byte], <<?[Byte], <<?[Int], <<?[String]))
  }
  /** Table description of table chrAncestries. Objects of this class serve as prototypes for rows in queries. */
  class Chrancestries(_tableTag: Tag) extends Table[ChrancestriesRow](_tableTag, Some("dbo"), "chrAncestries") {
    def * = (ancestryid, ancestryname, bloodlineid, description, perception, willpower, charisma, memory, intelligence, iconid, shortdescription) <> (ChrancestriesRow.tupled, ChrancestriesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (ancestryid.?, ancestryname, bloodlineid, description, perception, willpower, charisma, memory, intelligence, iconid, shortdescription).shaped.<>({r=>import r._; _1.map(_=> ChrancestriesRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column ancestryID DBType(tinyint), PrimaryKey */
    val ancestryid: Column[Byte] = column[Byte]("ancestryID", O.PrimaryKey)
    /** Database column ancestryName DBType(nvarchar), Length(100,true) */
    val ancestryname: Column[Option[String]] = column[Option[String]]("ancestryName", O.Length(100,varying=true))
    /** Database column bloodlineID DBType(tinyint) */
    val bloodlineid: Column[Option[Byte]] = column[Option[Byte]]("bloodlineID")
    /** Database column description DBType(nvarchar), Length(1000,true) */
    val description: Column[Option[String]] = column[Option[String]]("description", O.Length(1000,varying=true))
    /** Database column perception DBType(tinyint) */
    val perception: Column[Option[Byte]] = column[Option[Byte]]("perception")
    /** Database column willpower DBType(tinyint) */
    val willpower: Column[Option[Byte]] = column[Option[Byte]]("willpower")
    /** Database column charisma DBType(tinyint) */
    val charisma: Column[Option[Byte]] = column[Option[Byte]]("charisma")
    /** Database column memory DBType(tinyint) */
    val memory: Column[Option[Byte]] = column[Option[Byte]]("memory")
    /** Database column intelligence DBType(tinyint) */
    val intelligence: Column[Option[Byte]] = column[Option[Byte]]("intelligence")
    /** Database column iconID DBType(int) */
    val iconid: Column[Option[Int]] = column[Option[Int]]("iconID")
    /** Database column shortDescription DBType(nvarchar), Length(500,true) */
    val shortdescription: Column[Option[String]] = column[Option[String]]("shortDescription", O.Length(500,varying=true))
  }
  /** Collection-like TableQuery object for table Chrancestries */
  lazy val Chrancestries = new TableQuery(tag => new Chrancestries(tag))
  
  /** Entity class storing rows of table Chrattributes
   *  @param attributeid Database column attributeID DBType(tinyint), PrimaryKey
   *  @param attributename Database column attributeName DBType(varchar), Length(100,true)
   *  @param description Database column description DBType(varchar), Length(1000,true)
   *  @param iconid Database column iconID DBType(int)
   *  @param shortdescription Database column shortDescription DBType(nvarchar), Length(500,true)
   *  @param notes Database column notes DBType(nvarchar), Length(500,true) */
  case class ChrattributesRow(attributeid: Byte, attributename: Option[String], description: Option[String], iconid: Option[Int], shortdescription: Option[String], notes: Option[String])
  /** GetResult implicit for fetching ChrattributesRow objects using plain SQL queries */
  implicit def GetResultChrattributesRow(implicit e0: GR[Byte], e1: GR[Option[String]], e2: GR[Option[Int]]): GR[ChrattributesRow] = GR{
    prs => import prs._
    ChrattributesRow.tupled((<<[Byte], <<?[String], <<?[String], <<?[Int], <<?[String], <<?[String]))
  }
  /** Table description of table chrAttributes. Objects of this class serve as prototypes for rows in queries. */
  class Chrattributes(_tableTag: Tag) extends Table[ChrattributesRow](_tableTag, Some("dbo"), "chrAttributes") {
    def * = (attributeid, attributename, description, iconid, shortdescription, notes) <> (ChrattributesRow.tupled, ChrattributesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (attributeid.?, attributename, description, iconid, shortdescription, notes).shaped.<>({r=>import r._; _1.map(_=> ChrattributesRow.tupled((_1.get, _2, _3, _4, _5, _6)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column attributeID DBType(tinyint), PrimaryKey */
    val attributeid: Column[Byte] = column[Byte]("attributeID", O.PrimaryKey)
    /** Database column attributeName DBType(varchar), Length(100,true) */
    val attributename: Column[Option[String]] = column[Option[String]]("attributeName", O.Length(100,varying=true))
    /** Database column description DBType(varchar), Length(1000,true) */
    val description: Column[Option[String]] = column[Option[String]]("description", O.Length(1000,varying=true))
    /** Database column iconID DBType(int) */
    val iconid: Column[Option[Int]] = column[Option[Int]]("iconID")
    /** Database column shortDescription DBType(nvarchar), Length(500,true) */
    val shortdescription: Column[Option[String]] = column[Option[String]]("shortDescription", O.Length(500,varying=true))
    /** Database column notes DBType(nvarchar), Length(500,true) */
    val notes: Column[Option[String]] = column[Option[String]]("notes", O.Length(500,varying=true))
  }
  /** Collection-like TableQuery object for table Chrattributes */
  lazy val Chrattributes = new TableQuery(tag => new Chrattributes(tag))
  
  /** Entity class storing rows of table Chrbloodlines
   *  @param bloodlineid Database column bloodlineID DBType(tinyint), PrimaryKey
   *  @param bloodlinename Database column bloodlineName DBType(nvarchar), Length(100,true)
   *  @param raceid Database column raceID DBType(tinyint)
   *  @param description Database column description DBType(nvarchar), Length(1000,true)
   *  @param maledescription Database column maleDescription DBType(nvarchar), Length(1000,true)
   *  @param femaledescription Database column femaleDescription DBType(nvarchar), Length(1000,true)
   *  @param shiptypeid Database column shipTypeID DBType(int)
   *  @param corporationid Database column corporationID DBType(int)
   *  @param perception Database column perception DBType(tinyint)
   *  @param willpower Database column willpower DBType(tinyint)
   *  @param charisma Database column charisma DBType(tinyint)
   *  @param memory Database column memory DBType(tinyint)
   *  @param intelligence Database column intelligence DBType(tinyint)
   *  @param iconid Database column iconID DBType(int)
   *  @param shortdescription Database column shortDescription DBType(nvarchar), Length(500,true)
   *  @param shortmaledescription Database column shortMaleDescription DBType(nvarchar), Length(500,true)
   *  @param shortfemaledescription Database column shortFemaleDescription DBType(nvarchar), Length(500,true) */
  case class ChrbloodlinesRow(bloodlineid: Byte, bloodlinename: Option[String], raceid: Option[Byte], description: Option[String], maledescription: Option[String], femaledescription: Option[String], shiptypeid: Option[Int], corporationid: Option[Int], perception: Option[Byte], willpower: Option[Byte], charisma: Option[Byte], memory: Option[Byte], intelligence: Option[Byte], iconid: Option[Int], shortdescription: Option[String], shortmaledescription: Option[String], shortfemaledescription: Option[String])
  /** GetResult implicit for fetching ChrbloodlinesRow objects using plain SQL queries */
  implicit def GetResultChrbloodlinesRow(implicit e0: GR[Byte], e1: GR[Option[String]], e2: GR[Option[Byte]], e3: GR[Option[Int]]): GR[ChrbloodlinesRow] = GR{
    prs => import prs._
    ChrbloodlinesRow.tupled((<<[Byte], <<?[String], <<?[Byte], <<?[String], <<?[String], <<?[String], <<?[Int], <<?[Int], <<?[Byte], <<?[Byte], <<?[Byte], <<?[Byte], <<?[Byte], <<?[Int], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table chrBloodlines. Objects of this class serve as prototypes for rows in queries. */
  class Chrbloodlines(_tableTag: Tag) extends Table[ChrbloodlinesRow](_tableTag, Some("dbo"), "chrBloodlines") {
    def * = (bloodlineid, bloodlinename, raceid, description, maledescription, femaledescription, shiptypeid, corporationid, perception, willpower, charisma, memory, intelligence, iconid, shortdescription, shortmaledescription, shortfemaledescription) <> (ChrbloodlinesRow.tupled, ChrbloodlinesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (bloodlineid.?, bloodlinename, raceid, description, maledescription, femaledescription, shiptypeid, corporationid, perception, willpower, charisma, memory, intelligence, iconid, shortdescription, shortmaledescription, shortfemaledescription).shaped.<>({r=>import r._; _1.map(_=> ChrbloodlinesRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column bloodlineID DBType(tinyint), PrimaryKey */
    val bloodlineid: Column[Byte] = column[Byte]("bloodlineID", O.PrimaryKey)
    /** Database column bloodlineName DBType(nvarchar), Length(100,true) */
    val bloodlinename: Column[Option[String]] = column[Option[String]]("bloodlineName", O.Length(100,varying=true))
    /** Database column raceID DBType(tinyint) */
    val raceid: Column[Option[Byte]] = column[Option[Byte]]("raceID")
    /** Database column description DBType(nvarchar), Length(1000,true) */
    val description: Column[Option[String]] = column[Option[String]]("description", O.Length(1000,varying=true))
    /** Database column maleDescription DBType(nvarchar), Length(1000,true) */
    val maledescription: Column[Option[String]] = column[Option[String]]("maleDescription", O.Length(1000,varying=true))
    /** Database column femaleDescription DBType(nvarchar), Length(1000,true) */
    val femaledescription: Column[Option[String]] = column[Option[String]]("femaleDescription", O.Length(1000,varying=true))
    /** Database column shipTypeID DBType(int) */
    val shiptypeid: Column[Option[Int]] = column[Option[Int]]("shipTypeID")
    /** Database column corporationID DBType(int) */
    val corporationid: Column[Option[Int]] = column[Option[Int]]("corporationID")
    /** Database column perception DBType(tinyint) */
    val perception: Column[Option[Byte]] = column[Option[Byte]]("perception")
    /** Database column willpower DBType(tinyint) */
    val willpower: Column[Option[Byte]] = column[Option[Byte]]("willpower")
    /** Database column charisma DBType(tinyint) */
    val charisma: Column[Option[Byte]] = column[Option[Byte]]("charisma")
    /** Database column memory DBType(tinyint) */
    val memory: Column[Option[Byte]] = column[Option[Byte]]("memory")
    /** Database column intelligence DBType(tinyint) */
    val intelligence: Column[Option[Byte]] = column[Option[Byte]]("intelligence")
    /** Database column iconID DBType(int) */
    val iconid: Column[Option[Int]] = column[Option[Int]]("iconID")
    /** Database column shortDescription DBType(nvarchar), Length(500,true) */
    val shortdescription: Column[Option[String]] = column[Option[String]]("shortDescription", O.Length(500,varying=true))
    /** Database column shortMaleDescription DBType(nvarchar), Length(500,true) */
    val shortmaledescription: Column[Option[String]] = column[Option[String]]("shortMaleDescription", O.Length(500,varying=true))
    /** Database column shortFemaleDescription DBType(nvarchar), Length(500,true) */
    val shortfemaledescription: Column[Option[String]] = column[Option[String]]("shortFemaleDescription", O.Length(500,varying=true))
  }
  /** Collection-like TableQuery object for table Chrbloodlines */
  lazy val Chrbloodlines = new TableQuery(tag => new Chrbloodlines(tag))
  
  /** Entity class storing rows of table Chrfactions
   *  @param factionid Database column factionID DBType(int), PrimaryKey
   *  @param factionname Database column factionName DBType(varchar), Length(100,true)
   *  @param description Database column description DBType(varchar), Length(1000,true)
   *  @param raceids Database column raceIDs DBType(int)
   *  @param solarsystemid Database column solarSystemID DBType(int)
   *  @param corporationid Database column corporationID DBType(int)
   *  @param sizefactor Database column sizeFactor DBType(float)
   *  @param stationcount Database column stationCount DBType(smallint)
   *  @param stationsystemcount Database column stationSystemCount DBType(smallint)
   *  @param militiacorporationid Database column militiaCorporationID DBType(int)
   *  @param iconid Database column iconID DBType(int) */
  case class ChrfactionsRow(factionid: Int, factionname: Option[String], description: Option[String], raceids: Option[Int], solarsystemid: Option[Int], corporationid: Option[Int], sizefactor: Option[Double], stationcount: Option[Short], stationsystemcount: Option[Short], militiacorporationid: Option[Int], iconid: Option[Int])
  /** GetResult implicit for fetching ChrfactionsRow objects using plain SQL queries */
  implicit def GetResultChrfactionsRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[Option[Int]], e3: GR[Option[Double]], e4: GR[Option[Short]]): GR[ChrfactionsRow] = GR{
    prs => import prs._
    ChrfactionsRow.tupled((<<[Int], <<?[String], <<?[String], <<?[Int], <<?[Int], <<?[Int], <<?[Double], <<?[Short], <<?[Short], <<?[Int], <<?[Int]))
  }
  /** Table description of table chrFactions. Objects of this class serve as prototypes for rows in queries. */
  class Chrfactions(_tableTag: Tag) extends Table[ChrfactionsRow](_tableTag, Some("dbo"), "chrFactions") {
    def * = (factionid, factionname, description, raceids, solarsystemid, corporationid, sizefactor, stationcount, stationsystemcount, militiacorporationid, iconid) <> (ChrfactionsRow.tupled, ChrfactionsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (factionid.?, factionname, description, raceids, solarsystemid, corporationid, sizefactor, stationcount, stationsystemcount, militiacorporationid, iconid).shaped.<>({r=>import r._; _1.map(_=> ChrfactionsRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column factionID DBType(int), PrimaryKey */
    val factionid: Column[Int] = column[Int]("factionID", O.PrimaryKey)
    /** Database column factionName DBType(varchar), Length(100,true) */
    val factionname: Column[Option[String]] = column[Option[String]]("factionName", O.Length(100,varying=true))
    /** Database column description DBType(varchar), Length(1000,true) */
    val description: Column[Option[String]] = column[Option[String]]("description", O.Length(1000,varying=true))
    /** Database column raceIDs DBType(int) */
    val raceids: Column[Option[Int]] = column[Option[Int]]("raceIDs")
    /** Database column solarSystemID DBType(int) */
    val solarsystemid: Column[Option[Int]] = column[Option[Int]]("solarSystemID")
    /** Database column corporationID DBType(int) */
    val corporationid: Column[Option[Int]] = column[Option[Int]]("corporationID")
    /** Database column sizeFactor DBType(float) */
    val sizefactor: Column[Option[Double]] = column[Option[Double]]("sizeFactor")
    /** Database column stationCount DBType(smallint) */
    val stationcount: Column[Option[Short]] = column[Option[Short]]("stationCount")
    /** Database column stationSystemCount DBType(smallint) */
    val stationsystemcount: Column[Option[Short]] = column[Option[Short]]("stationSystemCount")
    /** Database column militiaCorporationID DBType(int) */
    val militiacorporationid: Column[Option[Int]] = column[Option[Int]]("militiaCorporationID")
    /** Database column iconID DBType(int) */
    val iconid: Column[Option[Int]] = column[Option[Int]]("iconID")
  }
  /** Collection-like TableQuery object for table Chrfactions */
  lazy val Chrfactions = new TableQuery(tag => new Chrfactions(tag))
  
  /** Entity class storing rows of table Chrraces
   *  @param raceid Database column raceID DBType(tinyint), PrimaryKey
   *  @param racename Database column raceName DBType(varchar), Length(100,true)
   *  @param description Database column description DBType(varchar), Length(1000,true)
   *  @param iconid Database column iconID DBType(int)
   *  @param shortdescription Database column shortDescription DBType(varchar), Length(500,true) */
  case class ChrracesRow(raceid: Byte, racename: Option[String], description: Option[String], iconid: Option[Int], shortdescription: Option[String])
  /** GetResult implicit for fetching ChrracesRow objects using plain SQL queries */
  implicit def GetResultChrracesRow(implicit e0: GR[Byte], e1: GR[Option[String]], e2: GR[Option[Int]]): GR[ChrracesRow] = GR{
    prs => import prs._
    ChrracesRow.tupled((<<[Byte], <<?[String], <<?[String], <<?[Int], <<?[String]))
  }
  /** Table description of table chrRaces. Objects of this class serve as prototypes for rows in queries. */
  class Chrraces(_tableTag: Tag) extends Table[ChrracesRow](_tableTag, Some("dbo"), "chrRaces") {
    def * = (raceid, racename, description, iconid, shortdescription) <> (ChrracesRow.tupled, ChrracesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (raceid.?, racename, description, iconid, shortdescription).shaped.<>({r=>import r._; _1.map(_=> ChrracesRow.tupled((_1.get, _2, _3, _4, _5)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column raceID DBType(tinyint), PrimaryKey */
    val raceid: Column[Byte] = column[Byte]("raceID", O.PrimaryKey)
    /** Database column raceName DBType(varchar), Length(100,true) */
    val racename: Column[Option[String]] = column[Option[String]]("raceName", O.Length(100,varying=true))
    /** Database column description DBType(varchar), Length(1000,true) */
    val description: Column[Option[String]] = column[Option[String]]("description", O.Length(1000,varying=true))
    /** Database column iconID DBType(int) */
    val iconid: Column[Option[Int]] = column[Option[Int]]("iconID")
    /** Database column shortDescription DBType(varchar), Length(500,true) */
    val shortdescription: Column[Option[String]] = column[Option[String]]("shortDescription", O.Length(500,varying=true))
  }
  /** Collection-like TableQuery object for table Chrraces */
  lazy val Chrraces = new TableQuery(tag => new Chrraces(tag))
  
  /** Entity class storing rows of table Crpactivities
   *  @param activityid Database column activityID DBType(tinyint), PrimaryKey
   *  @param activityname Database column activityName DBType(nvarchar), Length(100,true)
   *  @param description Database column description DBType(nvarchar), Length(1000,true) */
  case class CrpactivitiesRow(activityid: Byte, activityname: Option[String], description: Option[String])
  /** GetResult implicit for fetching CrpactivitiesRow objects using plain SQL queries */
  implicit def GetResultCrpactivitiesRow(implicit e0: GR[Byte], e1: GR[Option[String]]): GR[CrpactivitiesRow] = GR{
    prs => import prs._
    CrpactivitiesRow.tupled((<<[Byte], <<?[String], <<?[String]))
  }
  /** Table description of table crpActivities. Objects of this class serve as prototypes for rows in queries. */
  class Crpactivities(_tableTag: Tag) extends Table[CrpactivitiesRow](_tableTag, Some("dbo"), "crpActivities") {
    def * = (activityid, activityname, description) <> (CrpactivitiesRow.tupled, CrpactivitiesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (activityid.?, activityname, description).shaped.<>({r=>import r._; _1.map(_=> CrpactivitiesRow.tupled((_1.get, _2, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column activityID DBType(tinyint), PrimaryKey */
    val activityid: Column[Byte] = column[Byte]("activityID", O.PrimaryKey)
    /** Database column activityName DBType(nvarchar), Length(100,true) */
    val activityname: Column[Option[String]] = column[Option[String]]("activityName", O.Length(100,varying=true))
    /** Database column description DBType(nvarchar), Length(1000,true) */
    val description: Column[Option[String]] = column[Option[String]]("description", O.Length(1000,varying=true))
  }
  /** Collection-like TableQuery object for table Crpactivities */
  lazy val Crpactivities = new TableQuery(tag => new Crpactivities(tag))
  
  /** Entity class storing rows of table Crpnpccorporationdivisions
   *  @param corporationid Database column corporationID DBType(int)
   *  @param divisionid Database column divisionID DBType(tinyint)
   *  @param size Database column size DBType(tinyint) */
  case class CrpnpccorporationdivisionsRow(corporationid: Int, divisionid: Byte, size: Option[Byte])
  /** GetResult implicit for fetching CrpnpccorporationdivisionsRow objects using plain SQL queries */
  implicit def GetResultCrpnpccorporationdivisionsRow(implicit e0: GR[Int], e1: GR[Byte], e2: GR[Option[Byte]]): GR[CrpnpccorporationdivisionsRow] = GR{
    prs => import prs._
    CrpnpccorporationdivisionsRow.tupled((<<[Int], <<[Byte], <<?[Byte]))
  }
  /** Table description of table crpNPCCorporationDivisions. Objects of this class serve as prototypes for rows in queries. */
  class Crpnpccorporationdivisions(_tableTag: Tag) extends Table[CrpnpccorporationdivisionsRow](_tableTag, Some("dbo"), "crpNPCCorporationDivisions") {
    def * = (corporationid, divisionid, size) <> (CrpnpccorporationdivisionsRow.tupled, CrpnpccorporationdivisionsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (corporationid.?, divisionid.?, size).shaped.<>({r=>import r._; _1.map(_=> CrpnpccorporationdivisionsRow.tupled((_1.get, _2.get, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column corporationID DBType(int) */
    val corporationid: Column[Int] = column[Int]("corporationID")
    /** Database column divisionID DBType(tinyint) */
    val divisionid: Column[Byte] = column[Byte]("divisionID")
    /** Database column size DBType(tinyint) */
    val size: Column[Option[Byte]] = column[Option[Byte]]("size")
    
    /** Primary key of Crpnpccorporationdivisions (database name crpNPCCorporationDivisions_PK) */
    val pk = primaryKey("crpNPCCorporationDivisions_PK", (corporationid, divisionid))
  }
  /** Collection-like TableQuery object for table Crpnpccorporationdivisions */
  lazy val Crpnpccorporationdivisions = new TableQuery(tag => new Crpnpccorporationdivisions(tag))
  
  /** Entity class storing rows of table Crpnpccorporationresearchfields
   *  @param skillid Database column skillID DBType(int)
   *  @param corporationid Database column corporationID DBType(int) */
  case class CrpnpccorporationresearchfieldsRow(skillid: Int, corporationid: Int)
  /** GetResult implicit for fetching CrpnpccorporationresearchfieldsRow objects using plain SQL queries */
  implicit def GetResultCrpnpccorporationresearchfieldsRow(implicit e0: GR[Int]): GR[CrpnpccorporationresearchfieldsRow] = GR{
    prs => import prs._
    CrpnpccorporationresearchfieldsRow.tupled((<<[Int], <<[Int]))
  }
  /** Table description of table crpNPCCorporationResearchFields. Objects of this class serve as prototypes for rows in queries. */
  class Crpnpccorporationresearchfields(_tableTag: Tag) extends Table[CrpnpccorporationresearchfieldsRow](_tableTag, Some("dbo"), "crpNPCCorporationResearchFields") {
    def * = (skillid, corporationid) <> (CrpnpccorporationresearchfieldsRow.tupled, CrpnpccorporationresearchfieldsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (skillid.?, corporationid.?).shaped.<>({r=>import r._; _1.map(_=> CrpnpccorporationresearchfieldsRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column skillID DBType(int) */
    val skillid: Column[Int] = column[Int]("skillID")
    /** Database column corporationID DBType(int) */
    val corporationid: Column[Int] = column[Int]("corporationID")
    
    /** Primary key of Crpnpccorporationresearchfields (database name crpNPCCorporationResearchFields_PK) */
    val pk = primaryKey("crpNPCCorporationResearchFields_PK", (skillid, corporationid))
  }
  /** Collection-like TableQuery object for table Crpnpccorporationresearchfields */
  lazy val Crpnpccorporationresearchfields = new TableQuery(tag => new Crpnpccorporationresearchfields(tag))
  
  /** Row type of table Crpnpccorporations */
  type CrpnpccorporationsRow = HCons[Int,HCons[Option[String],HCons[Option[String],HCons[Option[Int],HCons[Option[Int],HCons[Option[Byte],HCons[Option[Int],HCons[Option[Byte],HCons[Option[Int],HCons[Option[Byte],HCons[Option[Int],HCons[Option[Byte],HCons[Option[Int],HCons[Option[Int],HCons[Option[Long],HCons[Option[Int],HCons[Option[Double],HCons[Option[Boolean],HCons[Option[Byte],HCons[Option[Byte],HCons[Option[Byte],HCons[Option[Byte],HCons[Option[Int],HCons[Option[Double],HCons[Option[Short],HCons[Option[Short],HCons[Option[String],HCons[Option[Int],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for CrpnpccorporationsRow providing default values if available in the database schema. */
  def CrpnpccorporationsRow(corporationid: Int, size: Option[String], extent: Option[String], solarsystemid: Option[Int], investorid1: Option[Int], investorshares1: Option[Byte], investorid2: Option[Int], investorshares2: Option[Byte], investorid3: Option[Int], investorshares3: Option[Byte], investorid4: Option[Int], investorshares4: Option[Byte], friendid: Option[Int], enemyid: Option[Int], publicshares: Option[Long], initialprice: Option[Int], minsecurity: Option[Double], scattered: Option[Boolean], fringe: Option[Byte], corridor: Option[Byte], hub: Option[Byte], border: Option[Byte], factionid: Option[Int], sizefactor: Option[Double], stationcount: Option[Short], stationsystemcount: Option[Short], description: Option[String], iconid: Option[Int]): CrpnpccorporationsRow = {
    corporationid :: size :: extent :: solarsystemid :: investorid1 :: investorshares1 :: investorid2 :: investorshares2 :: investorid3 :: investorshares3 :: investorid4 :: investorshares4 :: friendid :: enemyid :: publicshares :: initialprice :: minsecurity :: scattered :: fringe :: corridor :: hub :: border :: factionid :: sizefactor :: stationcount :: stationsystemcount :: description :: iconid :: HNil
  }
  /** GetResult implicit for fetching CrpnpccorporationsRow objects using plain SQL queries */
  implicit def GetResultCrpnpccorporationsRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[Option[Int]], e3: GR[Option[Byte]], e4: GR[Option[Long]], e5: GR[Option[Double]], e6: GR[Option[Boolean]], e7: GR[Option[Short]]): GR[CrpnpccorporationsRow] = GR{
    prs => import prs._
    <<[Int] :: <<?[String] :: <<?[String] :: <<?[Int] :: <<?[Int] :: <<?[Byte] :: <<?[Int] :: <<?[Byte] :: <<?[Int] :: <<?[Byte] :: <<?[Int] :: <<?[Byte] :: <<?[Int] :: <<?[Int] :: <<?[Long] :: <<?[Int] :: <<?[Double] :: <<?[Boolean] :: <<?[Byte] :: <<?[Byte] :: <<?[Byte] :: <<?[Byte] :: <<?[Int] :: <<?[Double] :: <<?[Short] :: <<?[Short] :: <<?[String] :: <<?[Int] :: HNil
  }
  /** Table description of table crpNPCCorporations. Objects of this class serve as prototypes for rows in queries. */
  class Crpnpccorporations(_tableTag: Tag) extends Table[CrpnpccorporationsRow](_tableTag, Some("dbo"), "crpNPCCorporations") {
    def * = corporationid :: size :: extent :: solarsystemid :: investorid1 :: investorshares1 :: investorid2 :: investorshares2 :: investorid3 :: investorshares3 :: investorid4 :: investorshares4 :: friendid :: enemyid :: publicshares :: initialprice :: minsecurity :: scattered :: fringe :: corridor :: hub :: border :: factionid :: sizefactor :: stationcount :: stationsystemcount :: description :: iconid :: HNil
    
    /** Database column corporationID DBType(int), PrimaryKey */
    val corporationid: Column[Int] = column[Int]("corporationID", O.PrimaryKey)
    /** Database column size DBType(char), Length(1,false) */
    val size: Column[Option[String]] = column[Option[String]]("size", O.Length(1,varying=false))
    /** Database column extent DBType(char), Length(1,false) */
    val extent: Column[Option[String]] = column[Option[String]]("extent", O.Length(1,varying=false))
    /** Database column solarSystemID DBType(int) */
    val solarsystemid: Column[Option[Int]] = column[Option[Int]]("solarSystemID")
    /** Database column investorID1 DBType(int) */
    val investorid1: Column[Option[Int]] = column[Option[Int]]("investorID1")
    /** Database column investorShares1 DBType(tinyint) */
    val investorshares1: Column[Option[Byte]] = column[Option[Byte]]("investorShares1")
    /** Database column investorID2 DBType(int) */
    val investorid2: Column[Option[Int]] = column[Option[Int]]("investorID2")
    /** Database column investorShares2 DBType(tinyint) */
    val investorshares2: Column[Option[Byte]] = column[Option[Byte]]("investorShares2")
    /** Database column investorID3 DBType(int) */
    val investorid3: Column[Option[Int]] = column[Option[Int]]("investorID3")
    /** Database column investorShares3 DBType(tinyint) */
    val investorshares3: Column[Option[Byte]] = column[Option[Byte]]("investorShares3")
    /** Database column investorID4 DBType(int) */
    val investorid4: Column[Option[Int]] = column[Option[Int]]("investorID4")
    /** Database column investorShares4 DBType(tinyint) */
    val investorshares4: Column[Option[Byte]] = column[Option[Byte]]("investorShares4")
    /** Database column friendID DBType(int) */
    val friendid: Column[Option[Int]] = column[Option[Int]]("friendID")
    /** Database column enemyID DBType(int) */
    val enemyid: Column[Option[Int]] = column[Option[Int]]("enemyID")
    /** Database column publicShares DBType(bigint) */
    val publicshares: Column[Option[Long]] = column[Option[Long]]("publicShares")
    /** Database column initialPrice DBType(int) */
    val initialprice: Column[Option[Int]] = column[Option[Int]]("initialPrice")
    /** Database column minSecurity DBType(float) */
    val minsecurity: Column[Option[Double]] = column[Option[Double]]("minSecurity")
    /** Database column scattered DBType(bit) */
    val scattered: Column[Option[Boolean]] = column[Option[Boolean]]("scattered")
    /** Database column fringe DBType(tinyint) */
    val fringe: Column[Option[Byte]] = column[Option[Byte]]("fringe")
    /** Database column corridor DBType(tinyint) */
    val corridor: Column[Option[Byte]] = column[Option[Byte]]("corridor")
    /** Database column hub DBType(tinyint) */
    val hub: Column[Option[Byte]] = column[Option[Byte]]("hub")
    /** Database column border DBType(tinyint) */
    val border: Column[Option[Byte]] = column[Option[Byte]]("border")
    /** Database column factionID DBType(int) */
    val factionid: Column[Option[Int]] = column[Option[Int]]("factionID")
    /** Database column sizeFactor DBType(float) */
    val sizefactor: Column[Option[Double]] = column[Option[Double]]("sizeFactor")
    /** Database column stationCount DBType(smallint) */
    val stationcount: Column[Option[Short]] = column[Option[Short]]("stationCount")
    /** Database column stationSystemCount DBType(smallint) */
    val stationsystemcount: Column[Option[Short]] = column[Option[Short]]("stationSystemCount")
    /** Database column description DBType(nvarchar), Length(4000,true) */
    val description: Column[Option[String]] = column[Option[String]]("description", O.Length(4000,varying=true))
    /** Database column iconID DBType(int) */
    val iconid: Column[Option[Int]] = column[Option[Int]]("iconID")
  }
  /** Collection-like TableQuery object for table Crpnpccorporations */
  lazy val Crpnpccorporations = new TableQuery(tag => new Crpnpccorporations(tag))
  
  /** Entity class storing rows of table Crpnpccorporationtrades
   *  @param corporationid Database column corporationID DBType(int)
   *  @param typeid Database column typeID DBType(int) */
  case class CrpnpccorporationtradesRow(corporationid: Int, typeid: Int)
  /** GetResult implicit for fetching CrpnpccorporationtradesRow objects using plain SQL queries */
  implicit def GetResultCrpnpccorporationtradesRow(implicit e0: GR[Int]): GR[CrpnpccorporationtradesRow] = GR{
    prs => import prs._
    CrpnpccorporationtradesRow.tupled((<<[Int], <<[Int]))
  }
  /** Table description of table crpNPCCorporationTrades. Objects of this class serve as prototypes for rows in queries. */
  class Crpnpccorporationtrades(_tableTag: Tag) extends Table[CrpnpccorporationtradesRow](_tableTag, Some("dbo"), "crpNPCCorporationTrades") {
    def * = (corporationid, typeid) <> (CrpnpccorporationtradesRow.tupled, CrpnpccorporationtradesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (corporationid.?, typeid.?).shaped.<>({r=>import r._; _1.map(_=> CrpnpccorporationtradesRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column corporationID DBType(int) */
    val corporationid: Column[Int] = column[Int]("corporationID")
    /** Database column typeID DBType(int) */
    val typeid: Column[Int] = column[Int]("typeID")
    
    /** Primary key of Crpnpccorporationtrades (database name crpNPCCorporationTrades_PK) */
    val pk = primaryKey("crpNPCCorporationTrades_PK", (corporationid, typeid))
  }
  /** Collection-like TableQuery object for table Crpnpccorporationtrades */
  lazy val Crpnpccorporationtrades = new TableQuery(tag => new Crpnpccorporationtrades(tag))
  
  /** Entity class storing rows of table Crpnpcdivisions
   *  @param divisionid Database column divisionID DBType(tinyint), PrimaryKey
   *  @param divisionname Database column divisionName DBType(nvarchar), Length(100,true)
   *  @param description Database column description DBType(nvarchar), Length(1000,true)
   *  @param leadertype Database column leaderType DBType(nvarchar), Length(100,true) */
  case class CrpnpcdivisionsRow(divisionid: Byte, divisionname: Option[String], description: Option[String], leadertype: Option[String])
  /** GetResult implicit for fetching CrpnpcdivisionsRow objects using plain SQL queries */
  implicit def GetResultCrpnpcdivisionsRow(implicit e0: GR[Byte], e1: GR[Option[String]]): GR[CrpnpcdivisionsRow] = GR{
    prs => import prs._
    CrpnpcdivisionsRow.tupled((<<[Byte], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table crpNPCDivisions. Objects of this class serve as prototypes for rows in queries. */
  class Crpnpcdivisions(_tableTag: Tag) extends Table[CrpnpcdivisionsRow](_tableTag, Some("dbo"), "crpNPCDivisions") {
    def * = (divisionid, divisionname, description, leadertype) <> (CrpnpcdivisionsRow.tupled, CrpnpcdivisionsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (divisionid.?, divisionname, description, leadertype).shaped.<>({r=>import r._; _1.map(_=> CrpnpcdivisionsRow.tupled((_1.get, _2, _3, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column divisionID DBType(tinyint), PrimaryKey */
    val divisionid: Column[Byte] = column[Byte]("divisionID", O.PrimaryKey)
    /** Database column divisionName DBType(nvarchar), Length(100,true) */
    val divisionname: Column[Option[String]] = column[Option[String]]("divisionName", O.Length(100,varying=true))
    /** Database column description DBType(nvarchar), Length(1000,true) */
    val description: Column[Option[String]] = column[Option[String]]("description", O.Length(1000,varying=true))
    /** Database column leaderType DBType(nvarchar), Length(100,true) */
    val leadertype: Column[Option[String]] = column[Option[String]]("leaderType", O.Length(100,varying=true))
  }
  /** Collection-like TableQuery object for table Crpnpcdivisions */
  lazy val Crpnpcdivisions = new TableQuery(tag => new Crpnpcdivisions(tag))
  
  /** Entity class storing rows of table Dgmattributecategories
   *  @param categoryid Database column categoryID DBType(tinyint), PrimaryKey
   *  @param categoryname Database column categoryName DBType(nvarchar), Length(50,true)
   *  @param categorydescription Database column categoryDescription DBType(nvarchar), Length(200,true) */
  case class DgmattributecategoriesRow(categoryid: Byte, categoryname: Option[String], categorydescription: Option[String])
  /** GetResult implicit for fetching DgmattributecategoriesRow objects using plain SQL queries */
  implicit def GetResultDgmattributecategoriesRow(implicit e0: GR[Byte], e1: GR[Option[String]]): GR[DgmattributecategoriesRow] = GR{
    prs => import prs._
    DgmattributecategoriesRow.tupled((<<[Byte], <<?[String], <<?[String]))
  }
  /** Table description of table dgmAttributeCategories. Objects of this class serve as prototypes for rows in queries. */
  class Dgmattributecategories(_tableTag: Tag) extends Table[DgmattributecategoriesRow](_tableTag, Some("dbo"), "dgmAttributeCategories") {
    def * = (categoryid, categoryname, categorydescription) <> (DgmattributecategoriesRow.tupled, DgmattributecategoriesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (categoryid.?, categoryname, categorydescription).shaped.<>({r=>import r._; _1.map(_=> DgmattributecategoriesRow.tupled((_1.get, _2, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column categoryID DBType(tinyint), PrimaryKey */
    val categoryid: Column[Byte] = column[Byte]("categoryID", O.PrimaryKey)
    /** Database column categoryName DBType(nvarchar), Length(50,true) */
    val categoryname: Column[Option[String]] = column[Option[String]]("categoryName", O.Length(50,varying=true))
    /** Database column categoryDescription DBType(nvarchar), Length(200,true) */
    val categorydescription: Column[Option[String]] = column[Option[String]]("categoryDescription", O.Length(200,varying=true))
  }
  /** Collection-like TableQuery object for table Dgmattributecategories */
  lazy val Dgmattributecategories = new TableQuery(tag => new Dgmattributecategories(tag))
  
  /** Entity class storing rows of table Dgmattributetypes
   *  @param attributeid Database column attributeID DBType(smallint), PrimaryKey
   *  @param attributename Database column attributeName DBType(varchar), Length(100,true)
   *  @param description Database column description DBType(varchar), Length(1000,true)
   *  @param iconid Database column iconID DBType(int)
   *  @param defaultvalue Database column defaultValue DBType(float)
   *  @param published Database column published DBType(bit)
   *  @param displayname Database column displayName DBType(varchar), Length(100,true)
   *  @param unitid Database column unitID DBType(tinyint)
   *  @param stackable Database column stackable DBType(bit)
   *  @param highisgood Database column highIsGood DBType(bit)
   *  @param categoryid Database column categoryID DBType(tinyint) */
  case class DgmattributetypesRow(attributeid: Short, attributename: Option[String], description: Option[String], iconid: Option[Int], defaultvalue: Option[Double], published: Option[Boolean], displayname: Option[String], unitid: Option[Byte], stackable: Option[Boolean], highisgood: Option[Boolean], categoryid: Option[Byte])
  /** GetResult implicit for fetching DgmattributetypesRow objects using plain SQL queries */
  implicit def GetResultDgmattributetypesRow(implicit e0: GR[Short], e1: GR[Option[String]], e2: GR[Option[Int]], e3: GR[Option[Double]], e4: GR[Option[Boolean]], e5: GR[Option[Byte]]): GR[DgmattributetypesRow] = GR{
    prs => import prs._
    DgmattributetypesRow.tupled((<<[Short], <<?[String], <<?[String], <<?[Int], <<?[Double], <<?[Boolean], <<?[String], <<?[Byte], <<?[Boolean], <<?[Boolean], <<?[Byte]))
  }
  /** Table description of table dgmAttributeTypes. Objects of this class serve as prototypes for rows in queries. */
  class Dgmattributetypes(_tableTag: Tag) extends Table[DgmattributetypesRow](_tableTag, Some("dbo"), "dgmAttributeTypes") {
    def * = (attributeid, attributename, description, iconid, defaultvalue, published, displayname, unitid, stackable, highisgood, categoryid) <> (DgmattributetypesRow.tupled, DgmattributetypesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (attributeid.?, attributename, description, iconid, defaultvalue, published, displayname, unitid, stackable, highisgood, categoryid).shaped.<>({r=>import r._; _1.map(_=> DgmattributetypesRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column attributeID DBType(smallint), PrimaryKey */
    val attributeid: Column[Short] = column[Short]("attributeID", O.PrimaryKey)
    /** Database column attributeName DBType(varchar), Length(100,true) */
    val attributename: Column[Option[String]] = column[Option[String]]("attributeName", O.Length(100,varying=true))
    /** Database column description DBType(varchar), Length(1000,true) */
    val description: Column[Option[String]] = column[Option[String]]("description", O.Length(1000,varying=true))
    /** Database column iconID DBType(int) */
    val iconid: Column[Option[Int]] = column[Option[Int]]("iconID")
    /** Database column defaultValue DBType(float) */
    val defaultvalue: Column[Option[Double]] = column[Option[Double]]("defaultValue")
    /** Database column published DBType(bit) */
    val published: Column[Option[Boolean]] = column[Option[Boolean]]("published")
    /** Database column displayName DBType(varchar), Length(100,true) */
    val displayname: Column[Option[String]] = column[Option[String]]("displayName", O.Length(100,varying=true))
    /** Database column unitID DBType(tinyint) */
    val unitid: Column[Option[Byte]] = column[Option[Byte]]("unitID")
    /** Database column stackable DBType(bit) */
    val stackable: Column[Option[Boolean]] = column[Option[Boolean]]("stackable")
    /** Database column highIsGood DBType(bit) */
    val highisgood: Column[Option[Boolean]] = column[Option[Boolean]]("highIsGood")
    /** Database column categoryID DBType(tinyint) */
    val categoryid: Column[Option[Byte]] = column[Option[Byte]]("categoryID")
  }
  /** Collection-like TableQuery object for table Dgmattributetypes */
  lazy val Dgmattributetypes = new TableQuery(tag => new Dgmattributetypes(tag))
  
  /** Row type of table Dgmeffects */
  type DgmeffectsRow = HCons[Short,HCons[Option[String],HCons[Option[Short],HCons[Option[Int],HCons[Option[Int],HCons[Option[String],HCons[Option[String],HCons[Option[Int],HCons[Option[Boolean],HCons[Option[Boolean],HCons[Option[Short],HCons[Option[Short],HCons[Option[Short],HCons[Option[Short],HCons[Option[Short],HCons[Option[Boolean],HCons[Option[Boolean],HCons[Option[String],HCons[Option[Boolean],HCons[Option[Boolean],HCons[Option[Boolean],HCons[Option[Boolean],HCons[Option[Byte],HCons[Option[String],HCons[Option[Short],HCons[Option[Short],HCons[Option[Short],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for DgmeffectsRow providing default values if available in the database schema. */
  def DgmeffectsRow(effectid: Short, effectname: Option[String], effectcategory: Option[Short], preexpression: Option[Int], postexpression: Option[Int], description: Option[String], guid: Option[String], iconid: Option[Int], isoffensive: Option[Boolean], isassistance: Option[Boolean], durationattributeid: Option[Short], trackingspeedattributeid: Option[Short], dischargeattributeid: Option[Short], rangeattributeid: Option[Short], falloffattributeid: Option[Short], disallowautorepeat: Option[Boolean], published: Option[Boolean], displayname: Option[String], iswarpsafe: Option[Boolean], rangechance: Option[Boolean], electronicchance: Option[Boolean], propulsionchance: Option[Boolean], distribution: Option[Byte], sfxname: Option[String], npcusagechanceattributeid: Option[Short], npcactivationchanceattributeid: Option[Short], fittingusagechanceattributeid: Option[Short]): DgmeffectsRow = {
    effectid :: effectname :: effectcategory :: preexpression :: postexpression :: description :: guid :: iconid :: isoffensive :: isassistance :: durationattributeid :: trackingspeedattributeid :: dischargeattributeid :: rangeattributeid :: falloffattributeid :: disallowautorepeat :: published :: displayname :: iswarpsafe :: rangechance :: electronicchance :: propulsionchance :: distribution :: sfxname :: npcusagechanceattributeid :: npcactivationchanceattributeid :: fittingusagechanceattributeid :: HNil
  }
  /** GetResult implicit for fetching DgmeffectsRow objects using plain SQL queries */
  implicit def GetResultDgmeffectsRow(implicit e0: GR[Short], e1: GR[Option[String]], e2: GR[Option[Short]], e3: GR[Option[Int]], e4: GR[Option[Boolean]], e5: GR[Option[Byte]]): GR[DgmeffectsRow] = GR{
    prs => import prs._
    <<[Short] :: <<?[String] :: <<?[Short] :: <<?[Int] :: <<?[Int] :: <<?[String] :: <<?[String] :: <<?[Int] :: <<?[Boolean] :: <<?[Boolean] :: <<?[Short] :: <<?[Short] :: <<?[Short] :: <<?[Short] :: <<?[Short] :: <<?[Boolean] :: <<?[Boolean] :: <<?[String] :: <<?[Boolean] :: <<?[Boolean] :: <<?[Boolean] :: <<?[Boolean] :: <<?[Byte] :: <<?[String] :: <<?[Short] :: <<?[Short] :: <<?[Short] :: HNil
  }
  /** Table description of table dgmEffects. Objects of this class serve as prototypes for rows in queries. */
  class Dgmeffects(_tableTag: Tag) extends Table[DgmeffectsRow](_tableTag, Some("dbo"), "dgmEffects") {
    def * = effectid :: effectname :: effectcategory :: preexpression :: postexpression :: description :: guid :: iconid :: isoffensive :: isassistance :: durationattributeid :: trackingspeedattributeid :: dischargeattributeid :: rangeattributeid :: falloffattributeid :: disallowautorepeat :: published :: displayname :: iswarpsafe :: rangechance :: electronicchance :: propulsionchance :: distribution :: sfxname :: npcusagechanceattributeid :: npcactivationchanceattributeid :: fittingusagechanceattributeid :: HNil
    
    /** Database column effectID DBType(smallint), PrimaryKey */
    val effectid: Column[Short] = column[Short]("effectID", O.PrimaryKey)
    /** Database column effectName DBType(varchar), Length(400,true) */
    val effectname: Column[Option[String]] = column[Option[String]]("effectName", O.Length(400,varying=true))
    /** Database column effectCategory DBType(smallint) */
    val effectcategory: Column[Option[Short]] = column[Option[Short]]("effectCategory")
    /** Database column preExpression DBType(int) */
    val preexpression: Column[Option[Int]] = column[Option[Int]]("preExpression")
    /** Database column postExpression DBType(int) */
    val postexpression: Column[Option[Int]] = column[Option[Int]]("postExpression")
    /** Database column description DBType(varchar), Length(1000,true) */
    val description: Column[Option[String]] = column[Option[String]]("description", O.Length(1000,varying=true))
    /** Database column guid DBType(varchar), Length(60,true) */
    val guid: Column[Option[String]] = column[Option[String]]("guid", O.Length(60,varying=true))
    /** Database column iconID DBType(int) */
    val iconid: Column[Option[Int]] = column[Option[Int]]("iconID")
    /** Database column isOffensive DBType(bit) */
    val isoffensive: Column[Option[Boolean]] = column[Option[Boolean]]("isOffensive")
    /** Database column isAssistance DBType(bit) */
    val isassistance: Column[Option[Boolean]] = column[Option[Boolean]]("isAssistance")
    /** Database column durationAttributeID DBType(smallint) */
    val durationattributeid: Column[Option[Short]] = column[Option[Short]]("durationAttributeID")
    /** Database column trackingSpeedAttributeID DBType(smallint) */
    val trackingspeedattributeid: Column[Option[Short]] = column[Option[Short]]("trackingSpeedAttributeID")
    /** Database column dischargeAttributeID DBType(smallint) */
    val dischargeattributeid: Column[Option[Short]] = column[Option[Short]]("dischargeAttributeID")
    /** Database column rangeAttributeID DBType(smallint) */
    val rangeattributeid: Column[Option[Short]] = column[Option[Short]]("rangeAttributeID")
    /** Database column falloffAttributeID DBType(smallint) */
    val falloffattributeid: Column[Option[Short]] = column[Option[Short]]("falloffAttributeID")
    /** Database column disallowAutoRepeat DBType(bit) */
    val disallowautorepeat: Column[Option[Boolean]] = column[Option[Boolean]]("disallowAutoRepeat")
    /** Database column published DBType(bit) */
    val published: Column[Option[Boolean]] = column[Option[Boolean]]("published")
    /** Database column displayName DBType(varchar), Length(100,true) */
    val displayname: Column[Option[String]] = column[Option[String]]("displayName", O.Length(100,varying=true))
    /** Database column isWarpSafe DBType(bit) */
    val iswarpsafe: Column[Option[Boolean]] = column[Option[Boolean]]("isWarpSafe")
    /** Database column rangeChance DBType(bit) */
    val rangechance: Column[Option[Boolean]] = column[Option[Boolean]]("rangeChance")
    /** Database column electronicChance DBType(bit) */
    val electronicchance: Column[Option[Boolean]] = column[Option[Boolean]]("electronicChance")
    /** Database column propulsionChance DBType(bit) */
    val propulsionchance: Column[Option[Boolean]] = column[Option[Boolean]]("propulsionChance")
    /** Database column distribution DBType(tinyint) */
    val distribution: Column[Option[Byte]] = column[Option[Byte]]("distribution")
    /** Database column sfxName DBType(varchar), Length(20,true) */
    val sfxname: Column[Option[String]] = column[Option[String]]("sfxName", O.Length(20,varying=true))
    /** Database column npcUsageChanceAttributeID DBType(smallint) */
    val npcusagechanceattributeid: Column[Option[Short]] = column[Option[Short]]("npcUsageChanceAttributeID")
    /** Database column npcActivationChanceAttributeID DBType(smallint) */
    val npcactivationchanceattributeid: Column[Option[Short]] = column[Option[Short]]("npcActivationChanceAttributeID")
    /** Database column fittingUsageChanceAttributeID DBType(smallint) */
    val fittingusagechanceattributeid: Column[Option[Short]] = column[Option[Short]]("fittingUsageChanceAttributeID")
  }
  /** Collection-like TableQuery object for table Dgmeffects */
  lazy val Dgmeffects = new TableQuery(tag => new Dgmeffects(tag))
  
  /** Entity class storing rows of table Dgmtypeattributes
   *  @param typeid Database column typeID DBType(int)
   *  @param attributeid Database column attributeID DBType(smallint)
   *  @param valueint Database column valueInt DBType(int)
   *  @param valuefloat Database column valueFloat DBType(float) */
  case class DgmtypeattributesRow(typeid: Int, attributeid: Short, valueint: Option[Int], valuefloat: Option[Double])
  /** GetResult implicit for fetching DgmtypeattributesRow objects using plain SQL queries */
  implicit def GetResultDgmtypeattributesRow(implicit e0: GR[Int], e1: GR[Short], e2: GR[Option[Int]], e3: GR[Option[Double]]): GR[DgmtypeattributesRow] = GR{
    prs => import prs._
    DgmtypeattributesRow.tupled((<<[Int], <<[Short], <<?[Int], <<?[Double]))
  }
  /** Table description of table dgmTypeAttributes. Objects of this class serve as prototypes for rows in queries. */
  class Dgmtypeattributes(_tableTag: Tag) extends Table[DgmtypeattributesRow](_tableTag, Some("dbo"), "dgmTypeAttributes") {
    def * = (typeid, attributeid, valueint, valuefloat) <> (DgmtypeattributesRow.tupled, DgmtypeattributesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (typeid.?, attributeid.?, valueint, valuefloat).shaped.<>({r=>import r._; _1.map(_=> DgmtypeattributesRow.tupled((_1.get, _2.get, _3, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column typeID DBType(int) */
    val typeid: Column[Int] = column[Int]("typeID")
    /** Database column attributeID DBType(smallint) */
    val attributeid: Column[Short] = column[Short]("attributeID")
    /** Database column valueInt DBType(int) */
    val valueint: Column[Option[Int]] = column[Option[Int]]("valueInt")
    /** Database column valueFloat DBType(float) */
    val valuefloat: Column[Option[Double]] = column[Option[Double]]("valueFloat")
    
    /** Primary key of Dgmtypeattributes (database name dgmTypeAttributes_PK) */
    val pk = primaryKey("dgmTypeAttributes_PK", (typeid, attributeid))
  }
  /** Collection-like TableQuery object for table Dgmtypeattributes */
  lazy val Dgmtypeattributes = new TableQuery(tag => new Dgmtypeattributes(tag))
  
  /** Entity class storing rows of table Dgmtypeeffects
   *  @param typeid Database column typeID DBType(int)
   *  @param effectid Database column effectID DBType(smallint)
   *  @param isdefault Database column isDefault DBType(bit) */
  case class DgmtypeeffectsRow(typeid: Int, effectid: Short, isdefault: Option[Boolean])
  /** GetResult implicit for fetching DgmtypeeffectsRow objects using plain SQL queries */
  implicit def GetResultDgmtypeeffectsRow(implicit e0: GR[Int], e1: GR[Short], e2: GR[Option[Boolean]]): GR[DgmtypeeffectsRow] = GR{
    prs => import prs._
    DgmtypeeffectsRow.tupled((<<[Int], <<[Short], <<?[Boolean]))
  }
  /** Table description of table dgmTypeEffects. Objects of this class serve as prototypes for rows in queries. */
  class Dgmtypeeffects(_tableTag: Tag) extends Table[DgmtypeeffectsRow](_tableTag, Some("dbo"), "dgmTypeEffects") {
    def * = (typeid, effectid, isdefault) <> (DgmtypeeffectsRow.tupled, DgmtypeeffectsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (typeid.?, effectid.?, isdefault).shaped.<>({r=>import r._; _1.map(_=> DgmtypeeffectsRow.tupled((_1.get, _2.get, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column typeID DBType(int) */
    val typeid: Column[Int] = column[Int]("typeID")
    /** Database column effectID DBType(smallint) */
    val effectid: Column[Short] = column[Short]("effectID")
    /** Database column isDefault DBType(bit) */
    val isdefault: Column[Option[Boolean]] = column[Option[Boolean]]("isDefault")
    
    /** Primary key of Dgmtypeeffects (database name dgmTypeEffects_PK) */
    val pk = primaryKey("dgmTypeEffects_PK", (typeid, effectid))
  }
  /** Collection-like TableQuery object for table Dgmtypeeffects */
  lazy val Dgmtypeeffects = new TableQuery(tag => new Dgmtypeeffects(tag))
  
  /** Entity class storing rows of table Eveunits
   *  @param unitid Database column unitID DBType(tinyint), PrimaryKey
   *  @param unitname Database column unitName DBType(varchar), Length(100,true)
   *  @param displayname Database column displayName DBType(varchar), Length(50,true)
   *  @param description Database column description DBType(varchar), Length(1000,true) */
  case class EveunitsRow(unitid: Byte, unitname: Option[String], displayname: Option[String], description: Option[String])
  /** GetResult implicit for fetching EveunitsRow objects using plain SQL queries */
  implicit def GetResultEveunitsRow(implicit e0: GR[Byte], e1: GR[Option[String]]): GR[EveunitsRow] = GR{
    prs => import prs._
    EveunitsRow.tupled((<<[Byte], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table eveUnits. Objects of this class serve as prototypes for rows in queries. */
  class Eveunits(_tableTag: Tag) extends Table[EveunitsRow](_tableTag, Some("dbo"), "eveUnits") {
    def * = (unitid, unitname, displayname, description) <> (EveunitsRow.tupled, EveunitsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (unitid.?, unitname, displayname, description).shaped.<>({r=>import r._; _1.map(_=> EveunitsRow.tupled((_1.get, _2, _3, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column unitID DBType(tinyint), PrimaryKey */
    val unitid: Column[Byte] = column[Byte]("unitID", O.PrimaryKey)
    /** Database column unitName DBType(varchar), Length(100,true) */
    val unitname: Column[Option[String]] = column[Option[String]]("unitName", O.Length(100,varying=true))
    /** Database column displayName DBType(varchar), Length(50,true) */
    val displayname: Column[Option[String]] = column[Option[String]]("displayName", O.Length(50,varying=true))
    /** Database column description DBType(varchar), Length(1000,true) */
    val description: Column[Option[String]] = column[Option[String]]("description", O.Length(1000,varying=true))
  }
  /** Collection-like TableQuery object for table Eveunits */
  lazy val Eveunits = new TableQuery(tag => new Eveunits(tag))
  
  /** Entity class storing rows of table Invcategories
   *  @param categoryid Database column categoryID DBType(int), PrimaryKey
   *  @param categoryname Database column categoryName DBType(nvarchar), Length(100,true)
   *  @param description Database column description DBType(nvarchar), Length(3000,true)
   *  @param iconid Database column iconID DBType(int)
   *  @param published Database column published DBType(bit) */
  case class InvcategoriesRow(categoryid: Int, categoryname: Option[String], description: Option[String], iconid: Option[Int], published: Option[Boolean])
  /** GetResult implicit for fetching InvcategoriesRow objects using plain SQL queries */
  implicit def GetResultInvcategoriesRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[Option[Int]], e3: GR[Option[Boolean]]): GR[InvcategoriesRow] = GR{
    prs => import prs._
    InvcategoriesRow.tupled((<<[Int], <<?[String], <<?[String], <<?[Int], <<?[Boolean]))
  }
  /** Table description of table invCategories. Objects of this class serve as prototypes for rows in queries. */
  class Invcategories(_tableTag: Tag) extends Table[InvcategoriesRow](_tableTag, Some("dbo"), "invCategories") {
    def * = (categoryid, categoryname, description, iconid, published) <> (InvcategoriesRow.tupled, InvcategoriesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (categoryid.?, categoryname, description, iconid, published).shaped.<>({r=>import r._; _1.map(_=> InvcategoriesRow.tupled((_1.get, _2, _3, _4, _5)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column categoryID DBType(int), PrimaryKey */
    val categoryid: Column[Int] = column[Int]("categoryID", O.PrimaryKey)
    /** Database column categoryName DBType(nvarchar), Length(100,true) */
    val categoryname: Column[Option[String]] = column[Option[String]]("categoryName", O.Length(100,varying=true))
    /** Database column description DBType(nvarchar), Length(3000,true) */
    val description: Column[Option[String]] = column[Option[String]]("description", O.Length(3000,varying=true))
    /** Database column iconID DBType(int) */
    val iconid: Column[Option[Int]] = column[Option[Int]]("iconID")
    /** Database column published DBType(bit) */
    val published: Column[Option[Boolean]] = column[Option[Boolean]]("published")
  }
  /** Collection-like TableQuery object for table Invcategories */
  lazy val Invcategories = new TableQuery(tag => new Invcategories(tag))
  
  /** Entity class storing rows of table Invcontrabandtypes
   *  @param factionid Database column factionID DBType(int)
   *  @param typeid Database column typeID DBType(int)
   *  @param standingloss Database column standingLoss DBType(float)
   *  @param confiscateminsec Database column confiscateMinSec DBType(float)
   *  @param finebyvalue Database column fineByValue DBType(float)
   *  @param attackminsec Database column attackMinSec DBType(float) */
  case class InvcontrabandtypesRow(factionid: Int, typeid: Int, standingloss: Option[Double], confiscateminsec: Option[Double], finebyvalue: Option[Double], attackminsec: Option[Double])
  /** GetResult implicit for fetching InvcontrabandtypesRow objects using plain SQL queries */
  implicit def GetResultInvcontrabandtypesRow(implicit e0: GR[Int], e1: GR[Option[Double]]): GR[InvcontrabandtypesRow] = GR{
    prs => import prs._
    InvcontrabandtypesRow.tupled((<<[Int], <<[Int], <<?[Double], <<?[Double], <<?[Double], <<?[Double]))
  }
  /** Table description of table invContrabandTypes. Objects of this class serve as prototypes for rows in queries. */
  class Invcontrabandtypes(_tableTag: Tag) extends Table[InvcontrabandtypesRow](_tableTag, Some("dbo"), "invContrabandTypes") {
    def * = (factionid, typeid, standingloss, confiscateminsec, finebyvalue, attackminsec) <> (InvcontrabandtypesRow.tupled, InvcontrabandtypesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (factionid.?, typeid.?, standingloss, confiscateminsec, finebyvalue, attackminsec).shaped.<>({r=>import r._; _1.map(_=> InvcontrabandtypesRow.tupled((_1.get, _2.get, _3, _4, _5, _6)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column factionID DBType(int) */
    val factionid: Column[Int] = column[Int]("factionID")
    /** Database column typeID DBType(int) */
    val typeid: Column[Int] = column[Int]("typeID")
    /** Database column standingLoss DBType(float) */
    val standingloss: Column[Option[Double]] = column[Option[Double]]("standingLoss")
    /** Database column confiscateMinSec DBType(float) */
    val confiscateminsec: Column[Option[Double]] = column[Option[Double]]("confiscateMinSec")
    /** Database column fineByValue DBType(float) */
    val finebyvalue: Column[Option[Double]] = column[Option[Double]]("fineByValue")
    /** Database column attackMinSec DBType(float) */
    val attackminsec: Column[Option[Double]] = column[Option[Double]]("attackMinSec")
    
    /** Primary key of Invcontrabandtypes (database name invContrabandTypes_PK) */
    val pk = primaryKey("invContrabandTypes_PK", (factionid, typeid))
    
    /** Index over (typeid) (database name invContrabandTypes_IX_type) */
    val index1 = index("invContrabandTypes_IX_type", typeid)
  }
  /** Collection-like TableQuery object for table Invcontrabandtypes */
  lazy val Invcontrabandtypes = new TableQuery(tag => new Invcontrabandtypes(tag))
  
  /** Entity class storing rows of table Invcontroltowerresourcepurposes
   *  @param purpose Database column purpose DBType(tinyint), PrimaryKey
   *  @param purposetext Database column purposeText DBType(varchar), Length(100,true) */
  case class InvcontroltowerresourcepurposesRow(purpose: Byte, purposetext: Option[String])
  /** GetResult implicit for fetching InvcontroltowerresourcepurposesRow objects using plain SQL queries */
  implicit def GetResultInvcontroltowerresourcepurposesRow(implicit e0: GR[Byte], e1: GR[Option[String]]): GR[InvcontroltowerresourcepurposesRow] = GR{
    prs => import prs._
    InvcontroltowerresourcepurposesRow.tupled((<<[Byte], <<?[String]))
  }
  /** Table description of table invControlTowerResourcePurposes. Objects of this class serve as prototypes for rows in queries. */
  class Invcontroltowerresourcepurposes(_tableTag: Tag) extends Table[InvcontroltowerresourcepurposesRow](_tableTag, Some("dbo"), "invControlTowerResourcePurposes") {
    def * = (purpose, purposetext) <> (InvcontroltowerresourcepurposesRow.tupled, InvcontroltowerresourcepurposesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (purpose.?, purposetext).shaped.<>({r=>import r._; _1.map(_=> InvcontroltowerresourcepurposesRow.tupled((_1.get, _2)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column purpose DBType(tinyint), PrimaryKey */
    val purpose: Column[Byte] = column[Byte]("purpose", O.PrimaryKey)
    /** Database column purposeText DBType(varchar), Length(100,true) */
    val purposetext: Column[Option[String]] = column[Option[String]]("purposeText", O.Length(100,varying=true))
  }
  /** Collection-like TableQuery object for table Invcontroltowerresourcepurposes */
  lazy val Invcontroltowerresourcepurposes = new TableQuery(tag => new Invcontroltowerresourcepurposes(tag))
  
  /** Entity class storing rows of table Invcontroltowerresources
   *  @param controltowertypeid Database column controlTowerTypeID DBType(int)
   *  @param resourcetypeid Database column resourceTypeID DBType(int)
   *  @param purpose Database column purpose DBType(tinyint)
   *  @param quantity Database column quantity DBType(int)
   *  @param minsecuritylevel Database column minSecurityLevel DBType(float)
   *  @param factionid Database column factionID DBType(int) */
  case class InvcontroltowerresourcesRow(controltowertypeid: Int, resourcetypeid: Int, purpose: Option[Byte], quantity: Option[Int], minsecuritylevel: Option[Double], factionid: Option[Int])
  /** GetResult implicit for fetching InvcontroltowerresourcesRow objects using plain SQL queries */
  implicit def GetResultInvcontroltowerresourcesRow(implicit e0: GR[Int], e1: GR[Option[Byte]], e2: GR[Option[Int]], e3: GR[Option[Double]]): GR[InvcontroltowerresourcesRow] = GR{
    prs => import prs._
    InvcontroltowerresourcesRow.tupled((<<[Int], <<[Int], <<?[Byte], <<?[Int], <<?[Double], <<?[Int]))
  }
  /** Table description of table invControlTowerResources. Objects of this class serve as prototypes for rows in queries. */
  class Invcontroltowerresources(_tableTag: Tag) extends Table[InvcontroltowerresourcesRow](_tableTag, Some("dbo"), "invControlTowerResources") {
    def * = (controltowertypeid, resourcetypeid, purpose, quantity, minsecuritylevel, factionid) <> (InvcontroltowerresourcesRow.tupled, InvcontroltowerresourcesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (controltowertypeid.?, resourcetypeid.?, purpose, quantity, minsecuritylevel, factionid).shaped.<>({r=>import r._; _1.map(_=> InvcontroltowerresourcesRow.tupled((_1.get, _2.get, _3, _4, _5, _6)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column controlTowerTypeID DBType(int) */
    val controltowertypeid: Column[Int] = column[Int]("controlTowerTypeID")
    /** Database column resourceTypeID DBType(int) */
    val resourcetypeid: Column[Int] = column[Int]("resourceTypeID")
    /** Database column purpose DBType(tinyint) */
    val purpose: Column[Option[Byte]] = column[Option[Byte]]("purpose")
    /** Database column quantity DBType(int) */
    val quantity: Column[Option[Int]] = column[Option[Int]]("quantity")
    /** Database column minSecurityLevel DBType(float) */
    val minsecuritylevel: Column[Option[Double]] = column[Option[Double]]("minSecurityLevel")
    /** Database column factionID DBType(int) */
    val factionid: Column[Option[Int]] = column[Option[Int]]("factionID")
    
    /** Primary key of Invcontroltowerresources (database name invControlTowerResources_PK) */
    val pk = primaryKey("invControlTowerResources_PK", (controltowertypeid, resourcetypeid))
  }
  /** Collection-like TableQuery object for table Invcontroltowerresources */
  lazy val Invcontroltowerresources = new TableQuery(tag => new Invcontroltowerresources(tag))
  
  /** Entity class storing rows of table Invflags
   *  @param flagid Database column flagID DBType(smallint), PrimaryKey
   *  @param flagname Database column flagName DBType(varchar), Length(200,true)
   *  @param flagtext Database column flagText DBType(varchar), Length(100,true)
   *  @param orderid Database column orderID DBType(int) */
  case class InvflagsRow(flagid: Short, flagname: Option[String], flagtext: Option[String], orderid: Option[Int])
  /** GetResult implicit for fetching InvflagsRow objects using plain SQL queries */
  implicit def GetResultInvflagsRow(implicit e0: GR[Short], e1: GR[Option[String]], e2: GR[Option[Int]]): GR[InvflagsRow] = GR{
    prs => import prs._
    InvflagsRow.tupled((<<[Short], <<?[String], <<?[String], <<?[Int]))
  }
  /** Table description of table invFlags. Objects of this class serve as prototypes for rows in queries. */
  class Invflags(_tableTag: Tag) extends Table[InvflagsRow](_tableTag, Some("dbo"), "invFlags") {
    def * = (flagid, flagname, flagtext, orderid) <> (InvflagsRow.tupled, InvflagsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (flagid.?, flagname, flagtext, orderid).shaped.<>({r=>import r._; _1.map(_=> InvflagsRow.tupled((_1.get, _2, _3, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column flagID DBType(smallint), PrimaryKey */
    val flagid: Column[Short] = column[Short]("flagID", O.PrimaryKey)
    /** Database column flagName DBType(varchar), Length(200,true) */
    val flagname: Column[Option[String]] = column[Option[String]]("flagName", O.Length(200,varying=true))
    /** Database column flagText DBType(varchar), Length(100,true) */
    val flagtext: Column[Option[String]] = column[Option[String]]("flagText", O.Length(100,varying=true))
    /** Database column orderID DBType(int) */
    val orderid: Column[Option[Int]] = column[Option[Int]]("orderID")
  }
  /** Collection-like TableQuery object for table Invflags */
  lazy val Invflags = new TableQuery(tag => new Invflags(tag))
  
  /** Entity class storing rows of table Invgroups
   *  @param groupid Database column groupID DBType(int), PrimaryKey
   *  @param categoryid Database column categoryID DBType(int)
   *  @param groupname Database column groupName DBType(nvarchar), Length(100,true)
   *  @param description Database column description DBType(nvarchar), Length(3000,true)
   *  @param iconid Database column iconID DBType(int)
   *  @param usebaseprice Database column useBasePrice DBType(bit)
   *  @param allowmanufacture Database column allowManufacture DBType(bit)
   *  @param allowrecycler Database column allowRecycler DBType(bit)
   *  @param anchored Database column anchored DBType(bit)
   *  @param anchorable Database column anchorable DBType(bit)
   *  @param fittablenonsingleton Database column fittableNonSingleton DBType(bit)
   *  @param published Database column published DBType(bit) */
  case class InvgroupsRow(groupid: Int, categoryid: Option[Int], groupname: Option[String], description: Option[String], iconid: Option[Int], usebaseprice: Option[Boolean], allowmanufacture: Option[Boolean], allowrecycler: Option[Boolean], anchored: Option[Boolean], anchorable: Option[Boolean], fittablenonsingleton: Option[Boolean], published: Option[Boolean])
  /** GetResult implicit for fetching InvgroupsRow objects using plain SQL queries */
  implicit def GetResultInvgroupsRow(implicit e0: GR[Int], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[Boolean]]): GR[InvgroupsRow] = GR{
    prs => import prs._
    InvgroupsRow.tupled((<<[Int], <<?[Int], <<?[String], <<?[String], <<?[Int], <<?[Boolean], <<?[Boolean], <<?[Boolean], <<?[Boolean], <<?[Boolean], <<?[Boolean], <<?[Boolean]))
  }
  /** Table description of table invGroups. Objects of this class serve as prototypes for rows in queries. */
  class Invgroups(_tableTag: Tag) extends Table[InvgroupsRow](_tableTag, Some("dbo"), "invGroups") {
    def * = (groupid, categoryid, groupname, description, iconid, usebaseprice, allowmanufacture, allowrecycler, anchored, anchorable, fittablenonsingleton, published) <> (InvgroupsRow.tupled, InvgroupsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (groupid.?, categoryid, groupname, description, iconid, usebaseprice, allowmanufacture, allowrecycler, anchored, anchorable, fittablenonsingleton, published).shaped.<>({r=>import r._; _1.map(_=> InvgroupsRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column groupID DBType(int), PrimaryKey */
    val groupid: Column[Int] = column[Int]("groupID", O.PrimaryKey)
    /** Database column categoryID DBType(int) */
    val categoryid: Column[Option[Int]] = column[Option[Int]]("categoryID")
    /** Database column groupName DBType(nvarchar), Length(100,true) */
    val groupname: Column[Option[String]] = column[Option[String]]("groupName", O.Length(100,varying=true))
    /** Database column description DBType(nvarchar), Length(3000,true) */
    val description: Column[Option[String]] = column[Option[String]]("description", O.Length(3000,varying=true))
    /** Database column iconID DBType(int) */
    val iconid: Column[Option[Int]] = column[Option[Int]]("iconID")
    /** Database column useBasePrice DBType(bit) */
    val usebaseprice: Column[Option[Boolean]] = column[Option[Boolean]]("useBasePrice")
    /** Database column allowManufacture DBType(bit) */
    val allowmanufacture: Column[Option[Boolean]] = column[Option[Boolean]]("allowManufacture")
    /** Database column allowRecycler DBType(bit) */
    val allowrecycler: Column[Option[Boolean]] = column[Option[Boolean]]("allowRecycler")
    /** Database column anchored DBType(bit) */
    val anchored: Column[Option[Boolean]] = column[Option[Boolean]]("anchored")
    /** Database column anchorable DBType(bit) */
    val anchorable: Column[Option[Boolean]] = column[Option[Boolean]]("anchorable")
    /** Database column fittableNonSingleton DBType(bit) */
    val fittablenonsingleton: Column[Option[Boolean]] = column[Option[Boolean]]("fittableNonSingleton")
    /** Database column published DBType(bit) */
    val published: Column[Option[Boolean]] = column[Option[Boolean]]("published")
    
    /** Index over (categoryid) (database name invGroups_IX_category) */
    val index1 = index("invGroups_IX_category", categoryid)
  }
  /** Collection-like TableQuery object for table Invgroups */
  lazy val Invgroups = new TableQuery(tag => new Invgroups(tag))
  
  /** Entity class storing rows of table Invitems
   *  @param itemid Database column itemID DBType(bigint), PrimaryKey
   *  @param typeid Database column typeID DBType(int)
   *  @param ownerid Database column ownerID DBType(int)
   *  @param locationid Database column locationID DBType(bigint)
   *  @param flagid Database column flagID DBType(smallint)
   *  @param quantity Database column quantity DBType(int) */
  case class InvitemsRow(itemid: Long, typeid: Int, ownerid: Int, locationid: Long, flagid: Short, quantity: Int)
  /** GetResult implicit for fetching InvitemsRow objects using plain SQL queries */
  implicit def GetResultInvitemsRow(implicit e0: GR[Long], e1: GR[Int], e2: GR[Short]): GR[InvitemsRow] = GR{
    prs => import prs._
    InvitemsRow.tupled((<<[Long], <<[Int], <<[Int], <<[Long], <<[Short], <<[Int]))
  }
  /** Table description of table invItems. Objects of this class serve as prototypes for rows in queries. */
  class Invitems(_tableTag: Tag) extends Table[InvitemsRow](_tableTag, Some("dbo"), "invItems") {
    def * = (itemid, typeid, ownerid, locationid, flagid, quantity) <> (InvitemsRow.tupled, InvitemsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (itemid.?, typeid.?, ownerid.?, locationid.?, flagid.?, quantity.?).shaped.<>({r=>import r._; _1.map(_=> InvitemsRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column itemID DBType(bigint), PrimaryKey */
    val itemid: Column[Long] = column[Long]("itemID", O.PrimaryKey)
    /** Database column typeID DBType(int) */
    val typeid: Column[Int] = column[Int]("typeID")
    /** Database column ownerID DBType(int) */
    val ownerid: Column[Int] = column[Int]("ownerID")
    /** Database column locationID DBType(bigint) */
    val locationid: Column[Long] = column[Long]("locationID")
    /** Database column flagID DBType(smallint) */
    val flagid: Column[Short] = column[Short]("flagID")
    /** Database column quantity DBType(int) */
    val quantity: Column[Int] = column[Int]("quantity")
    
    /** Index over (locationid) (database name items_IX_Location) */
    val index1 = index("items_IX_Location", locationid)
    /** Index over (ownerid,locationid) (database name items_IX_OwnerLocation) */
    val index2 = index("items_IX_OwnerLocation", (ownerid, locationid))
  }
  /** Collection-like TableQuery object for table Invitems */
  lazy val Invitems = new TableQuery(tag => new Invitems(tag))
  
  /** Entity class storing rows of table Invmarketgroups
   *  @param marketgroupid Database column marketGroupID DBType(int), PrimaryKey
   *  @param parentgroupid Database column parentGroupID DBType(int)
   *  @param marketgroupname Database column marketGroupName DBType(nvarchar), Length(100,true)
   *  @param description Database column description DBType(nvarchar), Length(3000,true)
   *  @param iconid Database column iconID DBType(int)
   *  @param hastypes Database column hasTypes DBType(bit) */
  case class InvmarketgroupsRow(marketgroupid: Int, parentgroupid: Option[Int], marketgroupname: Option[String], description: Option[String], iconid: Option[Int], hastypes: Option[Boolean])
  /** GetResult implicit for fetching InvmarketgroupsRow objects using plain SQL queries */
  implicit def GetResultInvmarketgroupsRow(implicit e0: GR[Int], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[Boolean]]): GR[InvmarketgroupsRow] = GR{
    prs => import prs._
    InvmarketgroupsRow.tupled((<<[Int], <<?[Int], <<?[String], <<?[String], <<?[Int], <<?[Boolean]))
  }
  /** Table description of table invMarketGroups. Objects of this class serve as prototypes for rows in queries. */
  class Invmarketgroups(_tableTag: Tag) extends Table[InvmarketgroupsRow](_tableTag, Some("dbo"), "invMarketGroups") {
    def * = (marketgroupid, parentgroupid, marketgroupname, description, iconid, hastypes) <> (InvmarketgroupsRow.tupled, InvmarketgroupsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (marketgroupid.?, parentgroupid, marketgroupname, description, iconid, hastypes).shaped.<>({r=>import r._; _1.map(_=> InvmarketgroupsRow.tupled((_1.get, _2, _3, _4, _5, _6)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column marketGroupID DBType(int), PrimaryKey */
    val marketgroupid: Column[Int] = column[Int]("marketGroupID", O.PrimaryKey)
    /** Database column parentGroupID DBType(int) */
    val parentgroupid: Column[Option[Int]] = column[Option[Int]]("parentGroupID")
    /** Database column marketGroupName DBType(nvarchar), Length(100,true) */
    val marketgroupname: Column[Option[String]] = column[Option[String]]("marketGroupName", O.Length(100,varying=true))
    /** Database column description DBType(nvarchar), Length(3000,true) */
    val description: Column[Option[String]] = column[Option[String]]("description", O.Length(3000,varying=true))
    /** Database column iconID DBType(int) */
    val iconid: Column[Option[Int]] = column[Option[Int]]("iconID")
    /** Database column hasTypes DBType(bit) */
    val hastypes: Column[Option[Boolean]] = column[Option[Boolean]]("hasTypes")
  }
  /** Collection-like TableQuery object for table Invmarketgroups */
  lazy val Invmarketgroups = new TableQuery(tag => new Invmarketgroups(tag))
  
  /** Entity class storing rows of table Invmetagroups
   *  @param metagroupid Database column metaGroupID DBType(smallint), PrimaryKey
   *  @param metagroupname Database column metaGroupName DBType(nvarchar), Length(100,true)
   *  @param description Database column description DBType(nvarchar), Length(1000,true)
   *  @param iconid Database column iconID DBType(int) */
  case class InvmetagroupsRow(metagroupid: Short, metagroupname: Option[String], description: Option[String], iconid: Option[Int])
  /** GetResult implicit for fetching InvmetagroupsRow objects using plain SQL queries */
  implicit def GetResultInvmetagroupsRow(implicit e0: GR[Short], e1: GR[Option[String]], e2: GR[Option[Int]]): GR[InvmetagroupsRow] = GR{
    prs => import prs._
    InvmetagroupsRow.tupled((<<[Short], <<?[String], <<?[String], <<?[Int]))
  }
  /** Table description of table invMetaGroups. Objects of this class serve as prototypes for rows in queries. */
  class Invmetagroups(_tableTag: Tag) extends Table[InvmetagroupsRow](_tableTag, Some("dbo"), "invMetaGroups") {
    def * = (metagroupid, metagroupname, description, iconid) <> (InvmetagroupsRow.tupled, InvmetagroupsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (metagroupid.?, metagroupname, description, iconid).shaped.<>({r=>import r._; _1.map(_=> InvmetagroupsRow.tupled((_1.get, _2, _3, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column metaGroupID DBType(smallint), PrimaryKey */
    val metagroupid: Column[Short] = column[Short]("metaGroupID", O.PrimaryKey)
    /** Database column metaGroupName DBType(nvarchar), Length(100,true) */
    val metagroupname: Column[Option[String]] = column[Option[String]]("metaGroupName", O.Length(100,varying=true))
    /** Database column description DBType(nvarchar), Length(1000,true) */
    val description: Column[Option[String]] = column[Option[String]]("description", O.Length(1000,varying=true))
    /** Database column iconID DBType(int) */
    val iconid: Column[Option[Int]] = column[Option[Int]]("iconID")
  }
  /** Collection-like TableQuery object for table Invmetagroups */
  lazy val Invmetagroups = new TableQuery(tag => new Invmetagroups(tag))
  
  /** Entity class storing rows of table Invmetatypes
   *  @param typeid Database column typeID DBType(int), PrimaryKey
   *  @param parenttypeid Database column parentTypeID DBType(int)
   *  @param metagroupid Database column metaGroupID DBType(smallint) */
  case class InvmetatypesRow(typeid: Int, parenttypeid: Option[Int], metagroupid: Option[Short])
  /** GetResult implicit for fetching InvmetatypesRow objects using plain SQL queries */
  implicit def GetResultInvmetatypesRow(implicit e0: GR[Int], e1: GR[Option[Int]], e2: GR[Option[Short]]): GR[InvmetatypesRow] = GR{
    prs => import prs._
    InvmetatypesRow.tupled((<<[Int], <<?[Int], <<?[Short]))
  }
  /** Table description of table invMetaTypes. Objects of this class serve as prototypes for rows in queries. */
  class Invmetatypes(_tableTag: Tag) extends Table[InvmetatypesRow](_tableTag, Some("dbo"), "invMetaTypes") {
    def * = (typeid, parenttypeid, metagroupid) <> (InvmetatypesRow.tupled, InvmetatypesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (typeid.?, parenttypeid, metagroupid).shaped.<>({r=>import r._; _1.map(_=> InvmetatypesRow.tupled((_1.get, _2, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column typeID DBType(int), PrimaryKey */
    val typeid: Column[Int] = column[Int]("typeID", O.PrimaryKey)
    /** Database column parentTypeID DBType(int) */
    val parenttypeid: Column[Option[Int]] = column[Option[Int]]("parentTypeID")
    /** Database column metaGroupID DBType(smallint) */
    val metagroupid: Column[Option[Short]] = column[Option[Short]]("metaGroupID")
  }
  /** Collection-like TableQuery object for table Invmetatypes */
  lazy val Invmetatypes = new TableQuery(tag => new Invmetatypes(tag))
  
  /** Entity class storing rows of table Invnames
   *  @param itemid Database column itemID DBType(bigint), PrimaryKey
   *  @param itemname Database column itemName DBType(nvarchar), Length(200,true) */
  case class InvnamesRow(itemid: Long, itemname: String)
  /** GetResult implicit for fetching InvnamesRow objects using plain SQL queries */
  implicit def GetResultInvnamesRow(implicit e0: GR[Long], e1: GR[String]): GR[InvnamesRow] = GR{
    prs => import prs._
    InvnamesRow.tupled((<<[Long], <<[String]))
  }
  /** Table description of table invNames. Objects of this class serve as prototypes for rows in queries. */
  class Invnames(_tableTag: Tag) extends Table[InvnamesRow](_tableTag, Some("dbo"), "invNames") {
    def * = (itemid, itemname) <> (InvnamesRow.tupled, InvnamesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (itemid.?, itemname.?).shaped.<>({r=>import r._; _1.map(_=> InvnamesRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column itemID DBType(bigint), PrimaryKey */
    val itemid: Column[Long] = column[Long]("itemID", O.PrimaryKey)
    /** Database column itemName DBType(nvarchar), Length(200,true) */
    val itemname: Column[String] = column[String]("itemName", O.Length(200,varying=true))
  }
  /** Collection-like TableQuery object for table Invnames */
  lazy val Invnames = new TableQuery(tag => new Invnames(tag))
  
  /** Entity class storing rows of table Invpositions
   *  @param itemid Database column itemID DBType(bigint), PrimaryKey
   *  @param x Database column x DBType(float)
   *  @param y Database column y DBType(float)
   *  @param z Database column z DBType(float)
   *  @param yaw Database column yaw DBType(real)
   *  @param pitch Database column pitch DBType(real)
   *  @param roll Database column roll DBType(real) */
  case class InvpositionsRow(itemid: Long, x: Double, y: Double, z: Double, yaw: Option[Float], pitch: Option[Float], roll: Option[Float])
  /** GetResult implicit for fetching InvpositionsRow objects using plain SQL queries */
  implicit def GetResultInvpositionsRow(implicit e0: GR[Long], e1: GR[Double], e2: GR[Option[Float]]): GR[InvpositionsRow] = GR{
    prs => import prs._
    InvpositionsRow.tupled((<<[Long], <<[Double], <<[Double], <<[Double], <<?[Float], <<?[Float], <<?[Float]))
  }
  /** Table description of table invPositions. Objects of this class serve as prototypes for rows in queries. */
  class Invpositions(_tableTag: Tag) extends Table[InvpositionsRow](_tableTag, Some("dbo"), "invPositions") {
    def * = (itemid, x, y, z, yaw, pitch, roll) <> (InvpositionsRow.tupled, InvpositionsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (itemid.?, x.?, y.?, z.?, yaw, pitch, roll).shaped.<>({r=>import r._; _1.map(_=> InvpositionsRow.tupled((_1.get, _2.get, _3.get, _4.get, _5, _6, _7)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column itemID DBType(bigint), PrimaryKey */
    val itemid: Column[Long] = column[Long]("itemID", O.PrimaryKey)
    /** Database column x DBType(float) */
    val x: Column[Double] = column[Double]("x")
    /** Database column y DBType(float) */
    val y: Column[Double] = column[Double]("y")
    /** Database column z DBType(float) */
    val z: Column[Double] = column[Double]("z")
    /** Database column yaw DBType(real) */
    val yaw: Column[Option[Float]] = column[Option[Float]]("yaw")
    /** Database column pitch DBType(real) */
    val pitch: Column[Option[Float]] = column[Option[Float]]("pitch")
    /** Database column roll DBType(real) */
    val roll: Column[Option[Float]] = column[Option[Float]]("roll")
  }
  /** Collection-like TableQuery object for table Invpositions */
  lazy val Invpositions = new TableQuery(tag => new Invpositions(tag))
  
  /** Entity class storing rows of table Invtypematerials
   *  @param typeid Database column typeID DBType(int)
   *  @param materialtypeid Database column materialTypeID DBType(int)
   *  @param quantity Database column quantity DBType(int) */
  case class InvtypematerialsRow(typeid: Int, materialtypeid: Int, quantity: Int)
  /** GetResult implicit for fetching InvtypematerialsRow objects using plain SQL queries */
  implicit def GetResultInvtypematerialsRow(implicit e0: GR[Int]): GR[InvtypematerialsRow] = GR{
    prs => import prs._
    InvtypematerialsRow.tupled((<<[Int], <<[Int], <<[Int]))
  }
  /** Table description of table invTypeMaterials. Objects of this class serve as prototypes for rows in queries. */
  class Invtypematerials(_tableTag: Tag) extends Table[InvtypematerialsRow](_tableTag, Some("dbo"), "invTypeMaterials") {
    def * = (typeid, materialtypeid, quantity) <> (InvtypematerialsRow.tupled, InvtypematerialsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (typeid.?, materialtypeid.?, quantity.?).shaped.<>({r=>import r._; _1.map(_=> InvtypematerialsRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column typeID DBType(int) */
    val typeid: Column[Int] = column[Int]("typeID")
    /** Database column materialTypeID DBType(int) */
    val materialtypeid: Column[Int] = column[Int]("materialTypeID")
    /** Database column quantity DBType(int) */
    val quantity: Column[Int] = column[Int]("quantity")
    
    /** Primary key of Invtypematerials (database name invTypeMaterials_PK) */
    val pk = primaryKey("invTypeMaterials_PK", (typeid, materialtypeid))
  }
  /** Collection-like TableQuery object for table Invtypematerials */
  lazy val Invtypematerials = new TableQuery(tag => new Invtypematerials(tag))
  
  /** Entity class storing rows of table Invtypereactions
   *  @param reactiontypeid Database column reactionTypeID DBType(int)
   *  @param input Database column input DBType(bit)
   *  @param typeid Database column typeID DBType(int)
   *  @param quantity Database column quantity DBType(smallint) */
  case class InvtypereactionsRow(reactiontypeid: Int, input: Boolean, typeid: Int, quantity: Option[Short])
  /** GetResult implicit for fetching InvtypereactionsRow objects using plain SQL queries */
  implicit def GetResultInvtypereactionsRow(implicit e0: GR[Int], e1: GR[Boolean], e2: GR[Option[Short]]): GR[InvtypereactionsRow] = GR{
    prs => import prs._
    InvtypereactionsRow.tupled((<<[Int], <<[Boolean], <<[Int], <<?[Short]))
  }
  /** Table description of table invTypeReactions. Objects of this class serve as prototypes for rows in queries. */
  class Invtypereactions(_tableTag: Tag) extends Table[InvtypereactionsRow](_tableTag, Some("dbo"), "invTypeReactions") {
    def * = (reactiontypeid, input, typeid, quantity) <> (InvtypereactionsRow.tupled, InvtypereactionsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (reactiontypeid.?, input.?, typeid.?, quantity).shaped.<>({r=>import r._; _1.map(_=> InvtypereactionsRow.tupled((_1.get, _2.get, _3.get, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column reactionTypeID DBType(int) */
    val reactiontypeid: Column[Int] = column[Int]("reactionTypeID")
    /** Database column input DBType(bit) */
    val input: Column[Boolean] = column[Boolean]("input")
    /** Database column typeID DBType(int) */
    val typeid: Column[Int] = column[Int]("typeID")
    /** Database column quantity DBType(smallint) */
    val quantity: Column[Option[Short]] = column[Option[Short]]("quantity")
    
    /** Primary key of Invtypereactions (database name pk_invTypeReactions) */
    val pk = primaryKey("pk_invTypeReactions", (reactiontypeid, input, typeid))
  }
  /** Collection-like TableQuery object for table Invtypereactions */
  lazy val Invtypereactions = new TableQuery(tag => new Invtypereactions(tag))
  
  /** Entity class storing rows of table Invtypes
   *  @param typeid Database column typeID DBType(int), PrimaryKey
   *  @param groupid Database column groupID DBType(int)
   *  @param typename Database column typeName DBType(nvarchar), Length(100,true)
   *  @param description Database column description DBType(nvarchar), Length(3000,true)
   *  @param mass Database column mass DBType(float)
   *  @param volume Database column volume DBType(float)
   *  @param capacity Database column capacity DBType(float)
   *  @param portionsize Database column portionSize DBType(int)
   *  @param raceid Database column raceID DBType(tinyint)
   *  @param baseprice Database column basePrice DBType(money)
   *  @param published Database column published DBType(bit)
   *  @param marketgroupid Database column marketGroupID DBType(int)
   *  @param chanceofduplicating Database column chanceOfDuplicating DBType(float) */
  case class InvtypesRow(typeid: Int, groupid: Option[Int], typename: Option[String], description: Option[String], mass: Option[Double], volume: Option[Double], capacity: Option[Double], portionsize: Option[Int], raceid: Option[Byte], baseprice: Option[scala.math.BigDecimal], published: Option[Boolean], marketgroupid: Option[Int], chanceofduplicating: Option[Double])
  /** GetResult implicit for fetching InvtypesRow objects using plain SQL queries */
  implicit def GetResultInvtypesRow(implicit e0: GR[Int], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[Double]], e4: GR[Option[Byte]], e5: GR[Option[scala.math.BigDecimal]], e6: GR[Option[Boolean]]): GR[InvtypesRow] = GR{
    prs => import prs._
    InvtypesRow.tupled((<<[Int], <<?[Int], <<?[String], <<?[String], <<?[Double], <<?[Double], <<?[Double], <<?[Int], <<?[Byte], <<?[scala.math.BigDecimal], <<?[Boolean], <<?[Int], <<?[Double]))
  }
  /** Table description of table invTypes. Objects of this class serve as prototypes for rows in queries. */
  class Invtypes(_tableTag: Tag) extends Table[InvtypesRow](_tableTag, Some("dbo"), "invTypes") {
    def * = (typeid, groupid, typename, description, mass, volume, capacity, portionsize, raceid, baseprice, published, marketgroupid, chanceofduplicating) <> (InvtypesRow.tupled, InvtypesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (typeid.?, groupid, typename, description, mass, volume, capacity, portionsize, raceid, baseprice, published, marketgroupid, chanceofduplicating).shaped.<>({r=>import r._; _1.map(_=> InvtypesRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column typeID DBType(int), PrimaryKey */
    val typeid: Column[Int] = column[Int]("typeID", O.PrimaryKey)
    /** Database column groupID DBType(int) */
    val groupid: Column[Option[Int]] = column[Option[Int]]("groupID")
    /** Database column typeName DBType(nvarchar), Length(100,true) */
    val typename: Column[Option[String]] = column[Option[String]]("typeName", O.Length(100,varying=true))
    /** Database column description DBType(nvarchar), Length(3000,true) */
    val description: Column[Option[String]] = column[Option[String]]("description", O.Length(3000,varying=true))
    /** Database column mass DBType(float) */
    val mass: Column[Option[Double]] = column[Option[Double]]("mass")
    /** Database column volume DBType(float) */
    val volume: Column[Option[Double]] = column[Option[Double]]("volume")
    /** Database column capacity DBType(float) */
    val capacity: Column[Option[Double]] = column[Option[Double]]("capacity")
    /** Database column portionSize DBType(int) */
    val portionsize: Column[Option[Int]] = column[Option[Int]]("portionSize")
    /** Database column raceID DBType(tinyint) */
    val raceid: Column[Option[Byte]] = column[Option[Byte]]("raceID")
    /** Database column basePrice DBType(money) */
    val baseprice: Column[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("basePrice")
    /** Database column published DBType(bit) */
    val published: Column[Option[Boolean]] = column[Option[Boolean]]("published")
    /** Database column marketGroupID DBType(int) */
    val marketgroupid: Column[Option[Int]] = column[Option[Int]]("marketGroupID")
    /** Database column chanceOfDuplicating DBType(float) */
    val chanceofduplicating: Column[Option[Double]] = column[Option[Double]]("chanceOfDuplicating")
    
    /** Index over (groupid) (database name invTypes_IX_Group) */
    val index1 = index("invTypes_IX_Group", groupid)
  }
  /** Collection-like TableQuery object for table Invtypes */
  lazy val Invtypes = new TableQuery(tag => new Invtypes(tag))
  
  /** Entity class storing rows of table Invuniquenames
   *  @param itemid Database column itemID DBType(int), PrimaryKey
   *  @param itemname Database column itemName DBType(nvarchar), Length(200,true)
   *  @param groupid Database column groupID DBType(int) */
  case class InvuniquenamesRow(itemid: Int, itemname: String, groupid: Option[Int])
  /** GetResult implicit for fetching InvuniquenamesRow objects using plain SQL queries */
  implicit def GetResultInvuniquenamesRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Option[Int]]): GR[InvuniquenamesRow] = GR{
    prs => import prs._
    InvuniquenamesRow.tupled((<<[Int], <<[String], <<?[Int]))
  }
  /** Table description of table invUniqueNames. Objects of this class serve as prototypes for rows in queries. */
  class Invuniquenames(_tableTag: Tag) extends Table[InvuniquenamesRow](_tableTag, Some("dbo"), "invUniqueNames") {
    def * = (itemid, itemname, groupid) <> (InvuniquenamesRow.tupled, InvuniquenamesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (itemid.?, itemname.?, groupid).shaped.<>({r=>import r._; _1.map(_=> InvuniquenamesRow.tupled((_1.get, _2.get, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column itemID DBType(int), PrimaryKey */
    val itemid: Column[Int] = column[Int]("itemID", O.PrimaryKey)
    /** Database column itemName DBType(nvarchar), Length(200,true) */
    val itemname: Column[String] = column[String]("itemName", O.Length(200,varying=true))
    /** Database column groupID DBType(int) */
    val groupid: Column[Option[Int]] = column[Option[Int]]("groupID")
    
    /** Index over (groupid,itemname) (database name invUniqueNames_IX_GroupName) */
    val index1 = index("invUniqueNames_IX_GroupName", (groupid, itemname))
    /** Uniqueness Index over (itemname) (database name invUniqueNames_UQ) */
    val index2 = index("invUniqueNames_UQ", itemname, unique=true)
  }
  /** Collection-like TableQuery object for table Invuniquenames */
  lazy val Invuniquenames = new TableQuery(tag => new Invuniquenames(tag))
  
  /** Entity class storing rows of table Mapuniverse
   *  @param universeid Database column universeID DBType(int), PrimaryKey
   *  @param universename Database column universeName DBType(varchar), Length(100,true)
   *  @param x Database column x DBType(float)
   *  @param y Database column y DBType(float)
   *  @param z Database column z DBType(float)
   *  @param xmin Database column xMin DBType(float)
   *  @param xmax Database column xMax DBType(float)
   *  @param ymin Database column yMin DBType(float)
   *  @param ymax Database column yMax DBType(float)
   *  @param zmin Database column zMin DBType(float)
   *  @param zmax Database column zMax DBType(float)
   *  @param radius Database column radius DBType(float) */
  case class MapuniverseRow(universeid: Int, universename: Option[String], x: Option[Double], y: Option[Double], z: Option[Double], xmin: Option[Double], xmax: Option[Double], ymin: Option[Double], ymax: Option[Double], zmin: Option[Double], zmax: Option[Double], radius: Option[Double])
  /** GetResult implicit for fetching MapuniverseRow objects using plain SQL queries */
  implicit def GetResultMapuniverseRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[Option[Double]]): GR[MapuniverseRow] = GR{
    prs => import prs._
    MapuniverseRow.tupled((<<[Int], <<?[String], <<?[Double], <<?[Double], <<?[Double], <<?[Double], <<?[Double], <<?[Double], <<?[Double], <<?[Double], <<?[Double], <<?[Double]))
  }
  /** Table description of table mapUniverse. Objects of this class serve as prototypes for rows in queries. */
  class Mapuniverse(_tableTag: Tag) extends Table[MapuniverseRow](_tableTag, Some("dbo"), "mapUniverse") {
    def * = (universeid, universename, x, y, z, xmin, xmax, ymin, ymax, zmin, zmax, radius) <> (MapuniverseRow.tupled, MapuniverseRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (universeid.?, universename, x, y, z, xmin, xmax, ymin, ymax, zmin, zmax, radius).shaped.<>({r=>import r._; _1.map(_=> MapuniverseRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column universeID DBType(int), PrimaryKey */
    val universeid: Column[Int] = column[Int]("universeID", O.PrimaryKey)
    /** Database column universeName DBType(varchar), Length(100,true) */
    val universename: Column[Option[String]] = column[Option[String]]("universeName", O.Length(100,varying=true))
    /** Database column x DBType(float) */
    val x: Column[Option[Double]] = column[Option[Double]]("x")
    /** Database column y DBType(float) */
    val y: Column[Option[Double]] = column[Option[Double]]("y")
    /** Database column z DBType(float) */
    val z: Column[Option[Double]] = column[Option[Double]]("z")
    /** Database column xMin DBType(float) */
    val xmin: Column[Option[Double]] = column[Option[Double]]("xMin")
    /** Database column xMax DBType(float) */
    val xmax: Column[Option[Double]] = column[Option[Double]]("xMax")
    /** Database column yMin DBType(float) */
    val ymin: Column[Option[Double]] = column[Option[Double]]("yMin")
    /** Database column yMax DBType(float) */
    val ymax: Column[Option[Double]] = column[Option[Double]]("yMax")
    /** Database column zMin DBType(float) */
    val zmin: Column[Option[Double]] = column[Option[Double]]("zMin")
    /** Database column zMax DBType(float) */
    val zmax: Column[Option[Double]] = column[Option[Double]]("zMax")
    /** Database column radius DBType(float) */
    val radius: Column[Option[Double]] = column[Option[Double]]("radius")
  }
  /** Collection-like TableQuery object for table Mapuniverse */
  lazy val Mapuniverse = new TableQuery(tag => new Mapuniverse(tag))
  
  /** Entity class storing rows of table Planetschematics
   *  @param schematicid Database column schematicID DBType(smallint), PrimaryKey
   *  @param schematicname Database column schematicName DBType(nvarchar), Length(255,true)
   *  @param cycletime Database column cycleTime DBType(int) */
  case class PlanetschematicsRow(schematicid: Short, schematicname: Option[String], cycletime: Option[Int])
  /** GetResult implicit for fetching PlanetschematicsRow objects using plain SQL queries */
  implicit def GetResultPlanetschematicsRow(implicit e0: GR[Short], e1: GR[Option[String]], e2: GR[Option[Int]]): GR[PlanetschematicsRow] = GR{
    prs => import prs._
    PlanetschematicsRow.tupled((<<[Short], <<?[String], <<?[Int]))
  }
  /** Table description of table planetSchematics. Objects of this class serve as prototypes for rows in queries. */
  class Planetschematics(_tableTag: Tag) extends Table[PlanetschematicsRow](_tableTag, Some("dbo"), "planetSchematics") {
    def * = (schematicid, schematicname, cycletime) <> (PlanetschematicsRow.tupled, PlanetschematicsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (schematicid.?, schematicname, cycletime).shaped.<>({r=>import r._; _1.map(_=> PlanetschematicsRow.tupled((_1.get, _2, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column schematicID DBType(smallint), PrimaryKey */
    val schematicid: Column[Short] = column[Short]("schematicID", O.PrimaryKey)
    /** Database column schematicName DBType(nvarchar), Length(255,true) */
    val schematicname: Column[Option[String]] = column[Option[String]]("schematicName", O.Length(255,varying=true))
    /** Database column cycleTime DBType(int) */
    val cycletime: Column[Option[Int]] = column[Option[Int]]("cycleTime")
  }
  /** Collection-like TableQuery object for table Planetschematics */
  lazy val Planetschematics = new TableQuery(tag => new Planetschematics(tag))
  
  /** Entity class storing rows of table Planetschematicspinmap
   *  @param schematicid Database column schematicID DBType(smallint)
   *  @param pintypeid Database column pinTypeID DBType(int) */
  case class PlanetschematicspinmapRow(schematicid: Short, pintypeid: Int)
  /** GetResult implicit for fetching PlanetschematicspinmapRow objects using plain SQL queries */
  implicit def GetResultPlanetschematicspinmapRow(implicit e0: GR[Short], e1: GR[Int]): GR[PlanetschematicspinmapRow] = GR{
    prs => import prs._
    PlanetschematicspinmapRow.tupled((<<[Short], <<[Int]))
  }
  /** Table description of table planetSchematicsPinMap. Objects of this class serve as prototypes for rows in queries. */
  class Planetschematicspinmap(_tableTag: Tag) extends Table[PlanetschematicspinmapRow](_tableTag, Some("dbo"), "planetSchematicsPinMap") {
    def * = (schematicid, pintypeid) <> (PlanetschematicspinmapRow.tupled, PlanetschematicspinmapRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (schematicid.?, pintypeid.?).shaped.<>({r=>import r._; _1.map(_=> PlanetschematicspinmapRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column schematicID DBType(smallint) */
    val schematicid: Column[Short] = column[Short]("schematicID")
    /** Database column pinTypeID DBType(int) */
    val pintypeid: Column[Int] = column[Int]("pinTypeID")
    
    /** Primary key of Planetschematicspinmap (database name planetSchematicsPinMap_PK) */
    val pk = primaryKey("planetSchematicsPinMap_PK", (schematicid, pintypeid))
  }
  /** Collection-like TableQuery object for table Planetschematicspinmap */
  lazy val Planetschematicspinmap = new TableQuery(tag => new Planetschematicspinmap(tag))
  
  /** Entity class storing rows of table Planetschematicstypemap
   *  @param schematicid Database column schematicID DBType(smallint)
   *  @param typeid Database column typeID DBType(int)
   *  @param quantity Database column quantity DBType(smallint)
   *  @param isinput Database column isInput DBType(bit) */
  case class PlanetschematicstypemapRow(schematicid: Short, typeid: Int, quantity: Option[Short], isinput: Option[Boolean])
  /** GetResult implicit for fetching PlanetschematicstypemapRow objects using plain SQL queries */
  implicit def GetResultPlanetschematicstypemapRow(implicit e0: GR[Short], e1: GR[Int], e2: GR[Option[Short]], e3: GR[Option[Boolean]]): GR[PlanetschematicstypemapRow] = GR{
    prs => import prs._
    PlanetschematicstypemapRow.tupled((<<[Short], <<[Int], <<?[Short], <<?[Boolean]))
  }
  /** Table description of table planetSchematicsTypeMap. Objects of this class serve as prototypes for rows in queries. */
  class Planetschematicstypemap(_tableTag: Tag) extends Table[PlanetschematicstypemapRow](_tableTag, Some("dbo"), "planetSchematicsTypeMap") {
    def * = (schematicid, typeid, quantity, isinput) <> (PlanetschematicstypemapRow.tupled, PlanetschematicstypemapRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (schematicid.?, typeid.?, quantity, isinput).shaped.<>({r=>import r._; _1.map(_=> PlanetschematicstypemapRow.tupled((_1.get, _2.get, _3, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column schematicID DBType(smallint) */
    val schematicid: Column[Short] = column[Short]("schematicID")
    /** Database column typeID DBType(int) */
    val typeid: Column[Int] = column[Int]("typeID")
    /** Database column quantity DBType(smallint) */
    val quantity: Column[Option[Short]] = column[Option[Short]]("quantity")
    /** Database column isInput DBType(bit) */
    val isinput: Column[Option[Boolean]] = column[Option[Boolean]]("isInput")
    
    /** Primary key of Planetschematicstypemap (database name planetSchematicsTypeMap_PK) */
    val pk = primaryKey("planetSchematicsTypeMap_PK", (schematicid, typeid))
  }
  /** Collection-like TableQuery object for table Planetschematicstypemap */
  lazy val Planetschematicstypemap = new TableQuery(tag => new Planetschematicstypemap(tag))
  
  /** Entity class storing rows of table Ramactivities
   *  @param activityid Database column activityID DBType(tinyint), PrimaryKey
   *  @param activityname Database column activityName DBType(nvarchar), Length(100,true)
   *  @param iconno Database column iconNo DBType(varchar), Length(5,true)
   *  @param description Database column description DBType(nvarchar), Length(1000,true)
   *  @param published Database column published DBType(bit) */
  case class RamactivitiesRow(activityid: Byte, activityname: Option[String], iconno: Option[String], description: Option[String], published: Option[Boolean])
  /** GetResult implicit for fetching RamactivitiesRow objects using plain SQL queries */
  implicit def GetResultRamactivitiesRow(implicit e0: GR[Byte], e1: GR[Option[String]], e2: GR[Option[Boolean]]): GR[RamactivitiesRow] = GR{
    prs => import prs._
    RamactivitiesRow.tupled((<<[Byte], <<?[String], <<?[String], <<?[String], <<?[Boolean]))
  }
  /** Table description of table ramActivities. Objects of this class serve as prototypes for rows in queries. */
  class Ramactivities(_tableTag: Tag) extends Table[RamactivitiesRow](_tableTag, Some("dbo"), "ramActivities") {
    def * = (activityid, activityname, iconno, description, published) <> (RamactivitiesRow.tupled, RamactivitiesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (activityid.?, activityname, iconno, description, published).shaped.<>({r=>import r._; _1.map(_=> RamactivitiesRow.tupled((_1.get, _2, _3, _4, _5)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column activityID DBType(tinyint), PrimaryKey */
    val activityid: Column[Byte] = column[Byte]("activityID", O.PrimaryKey)
    /** Database column activityName DBType(nvarchar), Length(100,true) */
    val activityname: Column[Option[String]] = column[Option[String]]("activityName", O.Length(100,varying=true))
    /** Database column iconNo DBType(varchar), Length(5,true) */
    val iconno: Column[Option[String]] = column[Option[String]]("iconNo", O.Length(5,varying=true))
    /** Database column description DBType(nvarchar), Length(1000,true) */
    val description: Column[Option[String]] = column[Option[String]]("description", O.Length(1000,varying=true))
    /** Database column published DBType(bit) */
    val published: Column[Option[Boolean]] = column[Option[Boolean]]("published")
  }
  /** Collection-like TableQuery object for table Ramactivities */
  lazy val Ramactivities = new TableQuery(tag => new Ramactivities(tag))
  
  /** Entity class storing rows of table Ramassemblylinestations
   *  @param stationid Database column stationID DBType(int)
   *  @param assemblylinetypeid Database column assemblyLineTypeID DBType(tinyint)
   *  @param quantity Database column quantity DBType(tinyint)
   *  @param stationtypeid Database column stationTypeID DBType(int)
   *  @param ownerid Database column ownerID DBType(int)
   *  @param solarsystemid Database column solarSystemID DBType(int)
   *  @param regionid Database column regionID DBType(int) */
  case class RamassemblylinestationsRow(stationid: Int, assemblylinetypeid: Byte, quantity: Option[Byte], stationtypeid: Option[Int], ownerid: Option[Int], solarsystemid: Option[Int], regionid: Option[Int])
  /** GetResult implicit for fetching RamassemblylinestationsRow objects using plain SQL queries */
  implicit def GetResultRamassemblylinestationsRow(implicit e0: GR[Int], e1: GR[Byte], e2: GR[Option[Byte]], e3: GR[Option[Int]]): GR[RamassemblylinestationsRow] = GR{
    prs => import prs._
    RamassemblylinestationsRow.tupled((<<[Int], <<[Byte], <<?[Byte], <<?[Int], <<?[Int], <<?[Int], <<?[Int]))
  }
  /** Table description of table ramAssemblyLineStations. Objects of this class serve as prototypes for rows in queries. */
  class Ramassemblylinestations(_tableTag: Tag) extends Table[RamassemblylinestationsRow](_tableTag, Some("dbo"), "ramAssemblyLineStations") {
    def * = (stationid, assemblylinetypeid, quantity, stationtypeid, ownerid, solarsystemid, regionid) <> (RamassemblylinestationsRow.tupled, RamassemblylinestationsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (stationid.?, assemblylinetypeid.?, quantity, stationtypeid, ownerid, solarsystemid, regionid).shaped.<>({r=>import r._; _1.map(_=> RamassemblylinestationsRow.tupled((_1.get, _2.get, _3, _4, _5, _6, _7)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column stationID DBType(int) */
    val stationid: Column[Int] = column[Int]("stationID")
    /** Database column assemblyLineTypeID DBType(tinyint) */
    val assemblylinetypeid: Column[Byte] = column[Byte]("assemblyLineTypeID")
    /** Database column quantity DBType(tinyint) */
    val quantity: Column[Option[Byte]] = column[Option[Byte]]("quantity")
    /** Database column stationTypeID DBType(int) */
    val stationtypeid: Column[Option[Int]] = column[Option[Int]]("stationTypeID")
    /** Database column ownerID DBType(int) */
    val ownerid: Column[Option[Int]] = column[Option[Int]]("ownerID")
    /** Database column solarSystemID DBType(int) */
    val solarsystemid: Column[Option[Int]] = column[Option[Int]]("solarSystemID")
    /** Database column regionID DBType(int) */
    val regionid: Column[Option[Int]] = column[Option[Int]]("regionID")
    
    /** Primary key of Ramassemblylinestations (database name ramAssemblyLineStations_PK) */
    val pk = primaryKey("ramAssemblyLineStations_PK", (stationid, assemblylinetypeid))
    
    /** Index over (ownerid) (database name ramAssemblyLineStations_IX_owner) */
    val index1 = index("ramAssemblyLineStations_IX_owner", ownerid)
    /** Index over (regionid) (database name ramAssemblyLineStations_IX_region) */
    val index2 = index("ramAssemblyLineStations_IX_region", regionid)
  }
  /** Collection-like TableQuery object for table Ramassemblylinestations */
  lazy val Ramassemblylinestations = new TableQuery(tag => new Ramassemblylinestations(tag))
  
  /** Entity class storing rows of table Ramassemblylinetypedetailpercategory
   *  @param assemblylinetypeid Database column assemblyLineTypeID DBType(tinyint)
   *  @param categoryid Database column categoryID DBType(int)
   *  @param timemultiplier Database column timeMultiplier DBType(float)
   *  @param materialmultiplier Database column materialMultiplier DBType(float)
   *  @param costmultiplier Database column costMultiplier DBType(float) */
  case class RamassemblylinetypedetailpercategoryRow(assemblylinetypeid: Byte, categoryid: Int, timemultiplier: Option[Double], materialmultiplier: Option[Double], costmultiplier: Option[Double])
  /** GetResult implicit for fetching RamassemblylinetypedetailpercategoryRow objects using plain SQL queries */
  implicit def GetResultRamassemblylinetypedetailpercategoryRow(implicit e0: GR[Byte], e1: GR[Int], e2: GR[Option[Double]]): GR[RamassemblylinetypedetailpercategoryRow] = GR{
    prs => import prs._
    RamassemblylinetypedetailpercategoryRow.tupled((<<[Byte], <<[Int], <<?[Double], <<?[Double], <<?[Double]))
  }
  /** Table description of table ramAssemblyLineTypeDetailPerCategory. Objects of this class serve as prototypes for rows in queries. */
  class Ramassemblylinetypedetailpercategory(_tableTag: Tag) extends Table[RamassemblylinetypedetailpercategoryRow](_tableTag, Some("dbo"), "ramAssemblyLineTypeDetailPerCategory") {
    def * = (assemblylinetypeid, categoryid, timemultiplier, materialmultiplier, costmultiplier) <> (RamassemblylinetypedetailpercategoryRow.tupled, RamassemblylinetypedetailpercategoryRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (assemblylinetypeid.?, categoryid.?, timemultiplier, materialmultiplier, costmultiplier).shaped.<>({r=>import r._; _1.map(_=> RamassemblylinetypedetailpercategoryRow.tupled((_1.get, _2.get, _3, _4, _5)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column assemblyLineTypeID DBType(tinyint) */
    val assemblylinetypeid: Column[Byte] = column[Byte]("assemblyLineTypeID")
    /** Database column categoryID DBType(int) */
    val categoryid: Column[Int] = column[Int]("categoryID")
    /** Database column timeMultiplier DBType(float) */
    val timemultiplier: Column[Option[Double]] = column[Option[Double]]("timeMultiplier")
    /** Database column materialMultiplier DBType(float) */
    val materialmultiplier: Column[Option[Double]] = column[Option[Double]]("materialMultiplier")
    /** Database column costMultiplier DBType(float) */
    val costmultiplier: Column[Option[Double]] = column[Option[Double]]("costMultiplier")
    
    /** Primary key of Ramassemblylinetypedetailpercategory (database name ramAssemblyLineTypeDetailPerCategory_PK) */
    val pk = primaryKey("ramAssemblyLineTypeDetailPerCategory_PK", (assemblylinetypeid, categoryid))
  }
  /** Collection-like TableQuery object for table Ramassemblylinetypedetailpercategory */
  lazy val Ramassemblylinetypedetailpercategory = new TableQuery(tag => new Ramassemblylinetypedetailpercategory(tag))
  
  /** Entity class storing rows of table Ramassemblylinetypedetailpergroup
   *  @param assemblylinetypeid Database column assemblyLineTypeID DBType(tinyint)
   *  @param groupid Database column groupID DBType(int)
   *  @param timemultiplier Database column timeMultiplier DBType(float)
   *  @param materialmultiplier Database column materialMultiplier DBType(float)
   *  @param costmultiplier Database column costMultiplier DBType(float) */
  case class RamassemblylinetypedetailpergroupRow(assemblylinetypeid: Byte, groupid: Int, timemultiplier: Option[Double], materialmultiplier: Option[Double], costmultiplier: Option[Double])
  /** GetResult implicit for fetching RamassemblylinetypedetailpergroupRow objects using plain SQL queries */
  implicit def GetResultRamassemblylinetypedetailpergroupRow(implicit e0: GR[Byte], e1: GR[Int], e2: GR[Option[Double]]): GR[RamassemblylinetypedetailpergroupRow] = GR{
    prs => import prs._
    RamassemblylinetypedetailpergroupRow.tupled((<<[Byte], <<[Int], <<?[Double], <<?[Double], <<?[Double]))
  }
  /** Table description of table ramAssemblyLineTypeDetailPerGroup. Objects of this class serve as prototypes for rows in queries. */
  class Ramassemblylinetypedetailpergroup(_tableTag: Tag) extends Table[RamassemblylinetypedetailpergroupRow](_tableTag, Some("dbo"), "ramAssemblyLineTypeDetailPerGroup") {
    def * = (assemblylinetypeid, groupid, timemultiplier, materialmultiplier, costmultiplier) <> (RamassemblylinetypedetailpergroupRow.tupled, RamassemblylinetypedetailpergroupRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (assemblylinetypeid.?, groupid.?, timemultiplier, materialmultiplier, costmultiplier).shaped.<>({r=>import r._; _1.map(_=> RamassemblylinetypedetailpergroupRow.tupled((_1.get, _2.get, _3, _4, _5)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column assemblyLineTypeID DBType(tinyint) */
    val assemblylinetypeid: Column[Byte] = column[Byte]("assemblyLineTypeID")
    /** Database column groupID DBType(int) */
    val groupid: Column[Int] = column[Int]("groupID")
    /** Database column timeMultiplier DBType(float) */
    val timemultiplier: Column[Option[Double]] = column[Option[Double]]("timeMultiplier")
    /** Database column materialMultiplier DBType(float) */
    val materialmultiplier: Column[Option[Double]] = column[Option[Double]]("materialMultiplier")
    /** Database column costMultiplier DBType(float) */
    val costmultiplier: Column[Option[Double]] = column[Option[Double]]("costMultiplier")
    
    /** Primary key of Ramassemblylinetypedetailpergroup (database name ramAssemblyLineTypeDetailPerGroup_PK) */
    val pk = primaryKey("ramAssemblyLineTypeDetailPerGroup_PK", (assemblylinetypeid, groupid))
  }
  /** Collection-like TableQuery object for table Ramassemblylinetypedetailpergroup */
  lazy val Ramassemblylinetypedetailpergroup = new TableQuery(tag => new Ramassemblylinetypedetailpergroup(tag))
  
  /** Entity class storing rows of table Ramassemblylinetypes
   *  @param assemblylinetypeid Database column assemblyLineTypeID DBType(tinyint), PrimaryKey
   *  @param assemblylinetypename Database column assemblyLineTypeName DBType(nvarchar), Length(100,true)
   *  @param description Database column description DBType(nvarchar), Length(1000,true)
   *  @param basetimemultiplier Database column baseTimeMultiplier DBType(float)
   *  @param basematerialmultiplier Database column baseMaterialMultiplier DBType(float)
   *  @param basecostmultiplier Database column baseCostMultiplier DBType(float)
   *  @param volume Database column volume DBType(float)
   *  @param activityid Database column activityID DBType(tinyint)
   *  @param mincostperhour Database column minCostPerHour DBType(float) */
  case class RamassemblylinetypesRow(assemblylinetypeid: Byte, assemblylinetypename: Option[String], description: Option[String], basetimemultiplier: Option[Double], basematerialmultiplier: Option[Double], basecostmultiplier: Option[Double], volume: Option[Double], activityid: Option[Byte], mincostperhour: Option[Double])
  /** GetResult implicit for fetching RamassemblylinetypesRow objects using plain SQL queries */
  implicit def GetResultRamassemblylinetypesRow(implicit e0: GR[Byte], e1: GR[Option[String]], e2: GR[Option[Double]], e3: GR[Option[Byte]]): GR[RamassemblylinetypesRow] = GR{
    prs => import prs._
    RamassemblylinetypesRow.tupled((<<[Byte], <<?[String], <<?[String], <<?[Double], <<?[Double], <<?[Double], <<?[Double], <<?[Byte], <<?[Double]))
  }
  /** Table description of table ramAssemblyLineTypes. Objects of this class serve as prototypes for rows in queries. */
  class Ramassemblylinetypes(_tableTag: Tag) extends Table[RamassemblylinetypesRow](_tableTag, Some("dbo"), "ramAssemblyLineTypes") {
    def * = (assemblylinetypeid, assemblylinetypename, description, basetimemultiplier, basematerialmultiplier, basecostmultiplier, volume, activityid, mincostperhour) <> (RamassemblylinetypesRow.tupled, RamassemblylinetypesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (assemblylinetypeid.?, assemblylinetypename, description, basetimemultiplier, basematerialmultiplier, basecostmultiplier, volume, activityid, mincostperhour).shaped.<>({r=>import r._; _1.map(_=> RamassemblylinetypesRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column assemblyLineTypeID DBType(tinyint), PrimaryKey */
    val assemblylinetypeid: Column[Byte] = column[Byte]("assemblyLineTypeID", O.PrimaryKey)
    /** Database column assemblyLineTypeName DBType(nvarchar), Length(100,true) */
    val assemblylinetypename: Column[Option[String]] = column[Option[String]]("assemblyLineTypeName", O.Length(100,varying=true))
    /** Database column description DBType(nvarchar), Length(1000,true) */
    val description: Column[Option[String]] = column[Option[String]]("description", O.Length(1000,varying=true))
    /** Database column baseTimeMultiplier DBType(float) */
    val basetimemultiplier: Column[Option[Double]] = column[Option[Double]]("baseTimeMultiplier")
    /** Database column baseMaterialMultiplier DBType(float) */
    val basematerialmultiplier: Column[Option[Double]] = column[Option[Double]]("baseMaterialMultiplier")
    /** Database column baseCostMultiplier DBType(float) */
    val basecostmultiplier: Column[Option[Double]] = column[Option[Double]]("baseCostMultiplier")
    /** Database column volume DBType(float) */
    val volume: Column[Option[Double]] = column[Option[Double]]("volume")
    /** Database column activityID DBType(tinyint) */
    val activityid: Column[Option[Byte]] = column[Option[Byte]]("activityID")
    /** Database column minCostPerHour DBType(float) */
    val mincostperhour: Column[Option[Double]] = column[Option[Double]]("minCostPerHour")
  }
  /** Collection-like TableQuery object for table Ramassemblylinetypes */
  lazy val Ramassemblylinetypes = new TableQuery(tag => new Ramassemblylinetypes(tag))
  
  /** Entity class storing rows of table Raminstallationtypecontents
   *  @param installationtypeid Database column installationTypeID DBType(int)
   *  @param assemblylinetypeid Database column assemblyLineTypeID DBType(tinyint)
   *  @param quantity Database column quantity DBType(tinyint) */
  case class RaminstallationtypecontentsRow(installationtypeid: Int, assemblylinetypeid: Byte, quantity: Option[Byte])
  /** GetResult implicit for fetching RaminstallationtypecontentsRow objects using plain SQL queries */
  implicit def GetResultRaminstallationtypecontentsRow(implicit e0: GR[Int], e1: GR[Byte], e2: GR[Option[Byte]]): GR[RaminstallationtypecontentsRow] = GR{
    prs => import prs._
    RaminstallationtypecontentsRow.tupled((<<[Int], <<[Byte], <<?[Byte]))
  }
  /** Table description of table ramInstallationTypeContents. Objects of this class serve as prototypes for rows in queries. */
  class Raminstallationtypecontents(_tableTag: Tag) extends Table[RaminstallationtypecontentsRow](_tableTag, Some("dbo"), "ramInstallationTypeContents") {
    def * = (installationtypeid, assemblylinetypeid, quantity) <> (RaminstallationtypecontentsRow.tupled, RaminstallationtypecontentsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (installationtypeid.?, assemblylinetypeid.?, quantity).shaped.<>({r=>import r._; _1.map(_=> RaminstallationtypecontentsRow.tupled((_1.get, _2.get, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column installationTypeID DBType(int) */
    val installationtypeid: Column[Int] = column[Int]("installationTypeID")
    /** Database column assemblyLineTypeID DBType(tinyint) */
    val assemblylinetypeid: Column[Byte] = column[Byte]("assemblyLineTypeID")
    /** Database column quantity DBType(tinyint) */
    val quantity: Column[Option[Byte]] = column[Option[Byte]]("quantity")
    
    /** Primary key of Raminstallationtypecontents (database name ramInstallationTypeContents_PK) */
    val pk = primaryKey("ramInstallationTypeContents_PK", (installationtypeid, assemblylinetypeid))
  }
  /** Collection-like TableQuery object for table Raminstallationtypecontents */
  lazy val Raminstallationtypecontents = new TableQuery(tag => new Raminstallationtypecontents(tag))
  
  /** Entity class storing rows of table Staoperations
   *  @param activityid Database column activityID DBType(tinyint)
   *  @param operationid Database column operationID DBType(tinyint), PrimaryKey
   *  @param operationname Database column operationName DBType(nvarchar), Length(100,true)
   *  @param description Database column description DBType(nvarchar), Length(1000,true)
   *  @param fringe Database column fringe DBType(tinyint)
   *  @param corridor Database column corridor DBType(tinyint)
   *  @param hub Database column hub DBType(tinyint)
   *  @param border Database column border DBType(tinyint)
   *  @param ratio Database column ratio DBType(tinyint)
   *  @param caldaristationtypeid Database column caldariStationTypeID DBType(int)
   *  @param minmatarstationtypeid Database column minmatarStationTypeID DBType(int)
   *  @param amarrstationtypeid Database column amarrStationTypeID DBType(int)
   *  @param gallentestationtypeid Database column gallenteStationTypeID DBType(int)
   *  @param jovestationtypeid Database column joveStationTypeID DBType(int) */
  case class StaoperationsRow(activityid: Option[Byte], operationid: Byte, operationname: Option[String], description: Option[String], fringe: Option[Byte], corridor: Option[Byte], hub: Option[Byte], border: Option[Byte], ratio: Option[Byte], caldaristationtypeid: Option[Int], minmatarstationtypeid: Option[Int], amarrstationtypeid: Option[Int], gallentestationtypeid: Option[Int], jovestationtypeid: Option[Int])
  /** GetResult implicit for fetching StaoperationsRow objects using plain SQL queries */
  implicit def GetResultStaoperationsRow(implicit e0: GR[Option[Byte]], e1: GR[Byte], e2: GR[Option[String]], e3: GR[Option[Int]]): GR[StaoperationsRow] = GR{
    prs => import prs._
    StaoperationsRow.tupled((<<?[Byte], <<[Byte], <<?[String], <<?[String], <<?[Byte], <<?[Byte], <<?[Byte], <<?[Byte], <<?[Byte], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int]))
  }
  /** Table description of table staOperations. Objects of this class serve as prototypes for rows in queries. */
  class Staoperations(_tableTag: Tag) extends Table[StaoperationsRow](_tableTag, Some("dbo"), "staOperations") {
    def * = (activityid, operationid, operationname, description, fringe, corridor, hub, border, ratio, caldaristationtypeid, minmatarstationtypeid, amarrstationtypeid, gallentestationtypeid, jovestationtypeid) <> (StaoperationsRow.tupled, StaoperationsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (activityid, operationid.?, operationname, description, fringe, corridor, hub, border, ratio, caldaristationtypeid, minmatarstationtypeid, amarrstationtypeid, gallentestationtypeid, jovestationtypeid).shaped.<>({r=>import r._; _2.map(_=> StaoperationsRow.tupled((_1, _2.get, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column activityID DBType(tinyint) */
    val activityid: Column[Option[Byte]] = column[Option[Byte]]("activityID")
    /** Database column operationID DBType(tinyint), PrimaryKey */
    val operationid: Column[Byte] = column[Byte]("operationID", O.PrimaryKey)
    /** Database column operationName DBType(nvarchar), Length(100,true) */
    val operationname: Column[Option[String]] = column[Option[String]]("operationName", O.Length(100,varying=true))
    /** Database column description DBType(nvarchar), Length(1000,true) */
    val description: Column[Option[String]] = column[Option[String]]("description", O.Length(1000,varying=true))
    /** Database column fringe DBType(tinyint) */
    val fringe: Column[Option[Byte]] = column[Option[Byte]]("fringe")
    /** Database column corridor DBType(tinyint) */
    val corridor: Column[Option[Byte]] = column[Option[Byte]]("corridor")
    /** Database column hub DBType(tinyint) */
    val hub: Column[Option[Byte]] = column[Option[Byte]]("hub")
    /** Database column border DBType(tinyint) */
    val border: Column[Option[Byte]] = column[Option[Byte]]("border")
    /** Database column ratio DBType(tinyint) */
    val ratio: Column[Option[Byte]] = column[Option[Byte]]("ratio")
    /** Database column caldariStationTypeID DBType(int) */
    val caldaristationtypeid: Column[Option[Int]] = column[Option[Int]]("caldariStationTypeID")
    /** Database column minmatarStationTypeID DBType(int) */
    val minmatarstationtypeid: Column[Option[Int]] = column[Option[Int]]("minmatarStationTypeID")
    /** Database column amarrStationTypeID DBType(int) */
    val amarrstationtypeid: Column[Option[Int]] = column[Option[Int]]("amarrStationTypeID")
    /** Database column gallenteStationTypeID DBType(int) */
    val gallentestationtypeid: Column[Option[Int]] = column[Option[Int]]("gallenteStationTypeID")
    /** Database column joveStationTypeID DBType(int) */
    val jovestationtypeid: Column[Option[Int]] = column[Option[Int]]("joveStationTypeID")
  }
  /** Collection-like TableQuery object for table Staoperations */
  lazy val Staoperations = new TableQuery(tag => new Staoperations(tag))
  
  /** Entity class storing rows of table Staoperationservices
   *  @param operationid Database column operationID DBType(tinyint)
   *  @param serviceid Database column serviceID DBType(int) */
  case class StaoperationservicesRow(operationid: Byte, serviceid: Int)
  /** GetResult implicit for fetching StaoperationservicesRow objects using plain SQL queries */
  implicit def GetResultStaoperationservicesRow(implicit e0: GR[Byte], e1: GR[Int]): GR[StaoperationservicesRow] = GR{
    prs => import prs._
    StaoperationservicesRow.tupled((<<[Byte], <<[Int]))
  }
  /** Table description of table staOperationServices. Objects of this class serve as prototypes for rows in queries. */
  class Staoperationservices(_tableTag: Tag) extends Table[StaoperationservicesRow](_tableTag, Some("dbo"), "staOperationServices") {
    def * = (operationid, serviceid) <> (StaoperationservicesRow.tupled, StaoperationservicesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (operationid.?, serviceid.?).shaped.<>({r=>import r._; _1.map(_=> StaoperationservicesRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column operationID DBType(tinyint) */
    val operationid: Column[Byte] = column[Byte]("operationID")
    /** Database column serviceID DBType(int) */
    val serviceid: Column[Int] = column[Int]("serviceID")
    
    /** Primary key of Staoperationservices (database name staOperationServices_PK) */
    val pk = primaryKey("staOperationServices_PK", (operationid, serviceid))
  }
  /** Collection-like TableQuery object for table Staoperationservices */
  lazy val Staoperationservices = new TableQuery(tag => new Staoperationservices(tag))
  
  /** Entity class storing rows of table Staservices
   *  @param serviceid Database column serviceID DBType(int), PrimaryKey
   *  @param servicename Database column serviceName DBType(nvarchar), Length(100,true)
   *  @param description Database column description DBType(nvarchar), Length(1000,true) */
  case class StaservicesRow(serviceid: Int, servicename: Option[String], description: Option[String])
  /** GetResult implicit for fetching StaservicesRow objects using plain SQL queries */
  implicit def GetResultStaservicesRow(implicit e0: GR[Int], e1: GR[Option[String]]): GR[StaservicesRow] = GR{
    prs => import prs._
    StaservicesRow.tupled((<<[Int], <<?[String], <<?[String]))
  }
  /** Table description of table staServices. Objects of this class serve as prototypes for rows in queries. */
  class Staservices(_tableTag: Tag) extends Table[StaservicesRow](_tableTag, Some("dbo"), "staServices") {
    def * = (serviceid, servicename, description) <> (StaservicesRow.tupled, StaservicesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (serviceid.?, servicename, description).shaped.<>({r=>import r._; _1.map(_=> StaservicesRow.tupled((_1.get, _2, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column serviceID DBType(int), PrimaryKey */
    val serviceid: Column[Int] = column[Int]("serviceID", O.PrimaryKey)
    /** Database column serviceName DBType(nvarchar), Length(100,true) */
    val servicename: Column[Option[String]] = column[Option[String]]("serviceName", O.Length(100,varying=true))
    /** Database column description DBType(nvarchar), Length(1000,true) */
    val description: Column[Option[String]] = column[Option[String]]("description", O.Length(1000,varying=true))
  }
  /** Collection-like TableQuery object for table Staservices */
  lazy val Staservices = new TableQuery(tag => new Staservices(tag))
  
  /** Entity class storing rows of table Stastations
   *  @param stationid Database column stationID DBType(int), PrimaryKey
   *  @param security Database column security DBType(smallint)
   *  @param dockingcostpervolume Database column dockingCostPerVolume DBType(float)
   *  @param maxshipvolumedockable Database column maxShipVolumeDockable DBType(float)
   *  @param officerentalcost Database column officeRentalCost DBType(int)
   *  @param operationid Database column operationID DBType(tinyint)
   *  @param stationtypeid Database column stationTypeID DBType(int)
   *  @param corporationid Database column corporationID DBType(int)
   *  @param solarsystemid Database column solarSystemID DBType(int)
   *  @param constellationid Database column constellationID DBType(int)
   *  @param regionid Database column regionID DBType(int)
   *  @param stationname Database column stationName DBType(nvarchar), Length(100,true)
   *  @param x Database column x DBType(float)
   *  @param y Database column y DBType(float)
   *  @param z Database column z DBType(float)
   *  @param reprocessingefficiency Database column reprocessingEfficiency DBType(float)
   *  @param reprocessingstationstake Database column reprocessingStationsTake DBType(float)
   *  @param reprocessinghangarflag Database column reprocessingHangarFlag DBType(tinyint) */
  case class StastationsRow(stationid: Int, security: Option[Short], dockingcostpervolume: Option[Double], maxshipvolumedockable: Option[Double], officerentalcost: Option[Int], operationid: Option[Byte], stationtypeid: Option[Int], corporationid: Option[Int], solarsystemid: Option[Int], constellationid: Option[Int], regionid: Option[Int], stationname: Option[String], x: Option[Double], y: Option[Double], z: Option[Double], reprocessingefficiency: Option[Double], reprocessingstationstake: Option[Double], reprocessinghangarflag: Option[Byte])
  /** GetResult implicit for fetching StastationsRow objects using plain SQL queries */
  implicit def GetResultStastationsRow(implicit e0: GR[Int], e1: GR[Option[Short]], e2: GR[Option[Double]], e3: GR[Option[Int]], e4: GR[Option[Byte]], e5: GR[Option[String]]): GR[StastationsRow] = GR{
    prs => import prs._
    StastationsRow.tupled((<<[Int], <<?[Short], <<?[Double], <<?[Double], <<?[Int], <<?[Byte], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[Int], <<?[String], <<?[Double], <<?[Double], <<?[Double], <<?[Double], <<?[Double], <<?[Byte]))
  }
  /** Table description of table staStations. Objects of this class serve as prototypes for rows in queries. */
  class Stastations(_tableTag: Tag) extends Table[StastationsRow](_tableTag, Some("dbo"), "staStations") {
    def * = (stationid, security, dockingcostpervolume, maxshipvolumedockable, officerentalcost, operationid, stationtypeid, corporationid, solarsystemid, constellationid, regionid, stationname, x, y, z, reprocessingefficiency, reprocessingstationstake, reprocessinghangarflag) <> (StastationsRow.tupled, StastationsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (stationid.?, security, dockingcostpervolume, maxshipvolumedockable, officerentalcost, operationid, stationtypeid, corporationid, solarsystemid, constellationid, regionid, stationname, x, y, z, reprocessingefficiency, reprocessingstationstake, reprocessinghangarflag).shaped.<>({r=>import r._; _1.map(_=> StastationsRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17, _18)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column stationID DBType(int), PrimaryKey */
    val stationid: Column[Int] = column[Int]("stationID", O.PrimaryKey)
    /** Database column security DBType(smallint) */
    val security: Column[Option[Short]] = column[Option[Short]]("security")
    /** Database column dockingCostPerVolume DBType(float) */
    val dockingcostpervolume: Column[Option[Double]] = column[Option[Double]]("dockingCostPerVolume")
    /** Database column maxShipVolumeDockable DBType(float) */
    val maxshipvolumedockable: Column[Option[Double]] = column[Option[Double]]("maxShipVolumeDockable")
    /** Database column officeRentalCost DBType(int) */
    val officerentalcost: Column[Option[Int]] = column[Option[Int]]("officeRentalCost")
    /** Database column operationID DBType(tinyint) */
    val operationid: Column[Option[Byte]] = column[Option[Byte]]("operationID")
    /** Database column stationTypeID DBType(int) */
    val stationtypeid: Column[Option[Int]] = column[Option[Int]]("stationTypeID")
    /** Database column corporationID DBType(int) */
    val corporationid: Column[Option[Int]] = column[Option[Int]]("corporationID")
    /** Database column solarSystemID DBType(int) */
    val solarsystemid: Column[Option[Int]] = column[Option[Int]]("solarSystemID")
    /** Database column constellationID DBType(int) */
    val constellationid: Column[Option[Int]] = column[Option[Int]]("constellationID")
    /** Database column regionID DBType(int) */
    val regionid: Column[Option[Int]] = column[Option[Int]]("regionID")
    /** Database column stationName DBType(nvarchar), Length(100,true) */
    val stationname: Column[Option[String]] = column[Option[String]]("stationName", O.Length(100,varying=true))
    /** Database column x DBType(float) */
    val x: Column[Option[Double]] = column[Option[Double]]("x")
    /** Database column y DBType(float) */
    val y: Column[Option[Double]] = column[Option[Double]]("y")
    /** Database column z DBType(float) */
    val z: Column[Option[Double]] = column[Option[Double]]("z")
    /** Database column reprocessingEfficiency DBType(float) */
    val reprocessingefficiency: Column[Option[Double]] = column[Option[Double]]("reprocessingEfficiency")
    /** Database column reprocessingStationsTake DBType(float) */
    val reprocessingstationstake: Column[Option[Double]] = column[Option[Double]]("reprocessingStationsTake")
    /** Database column reprocessingHangarFlag DBType(tinyint) */
    val reprocessinghangarflag: Column[Option[Byte]] = column[Option[Byte]]("reprocessingHangarFlag")
    
    /** Index over (constellationid) (database name staStations_IX_constellation) */
    val index1 = index("staStations_IX_constellation", constellationid)
    /** Index over (corporationid) (database name staStations_IX_corporation) */
    val index2 = index("staStations_IX_corporation", corporationid)
    /** Index over (operationid) (database name staStations_IX_operation) */
    val index3 = index("staStations_IX_operation", operationid)
    /** Index over (regionid) (database name staStations_IX_region) */
    val index4 = index("staStations_IX_region", regionid)
    /** Index over (solarsystemid) (database name staStations_IX_system) */
    val index5 = index("staStations_IX_system", solarsystemid)
    /** Index over (stationtypeid) (database name staStations_IX_type) */
    val index6 = index("staStations_IX_type", stationtypeid)
  }
  /** Collection-like TableQuery object for table Stastations */
  lazy val Stastations = new TableQuery(tag => new Stastations(tag))
  
  /** Entity class storing rows of table Stastationtypes
   *  @param stationtypeid Database column stationTypeID DBType(int), PrimaryKey
   *  @param dockentryx Database column dockEntryX DBType(float)
   *  @param dockentryy Database column dockEntryY DBType(float)
   *  @param dockentryz Database column dockEntryZ DBType(float)
   *  @param dockorientationx Database column dockOrientationX DBType(float)
   *  @param dockorientationy Database column dockOrientationY DBType(float)
   *  @param dockorientationz Database column dockOrientationZ DBType(float)
   *  @param operationid Database column operationID DBType(tinyint)
   *  @param officeslots Database column officeSlots DBType(tinyint)
   *  @param reprocessingefficiency Database column reprocessingEfficiency DBType(float)
   *  @param conquerable Database column conquerable DBType(bit) */
  case class StastationtypesRow(stationtypeid: Int, dockentryx: Option[Double], dockentryy: Option[Double], dockentryz: Option[Double], dockorientationx: Option[Double], dockorientationy: Option[Double], dockorientationz: Option[Double], operationid: Option[Byte], officeslots: Option[Byte], reprocessingefficiency: Option[Double], conquerable: Option[Boolean])
  /** GetResult implicit for fetching StastationtypesRow objects using plain SQL queries */
  implicit def GetResultStastationtypesRow(implicit e0: GR[Int], e1: GR[Option[Double]], e2: GR[Option[Byte]], e3: GR[Option[Boolean]]): GR[StastationtypesRow] = GR{
    prs => import prs._
    StastationtypesRow.tupled((<<[Int], <<?[Double], <<?[Double], <<?[Double], <<?[Double], <<?[Double], <<?[Double], <<?[Byte], <<?[Byte], <<?[Double], <<?[Boolean]))
  }
  /** Table description of table staStationTypes. Objects of this class serve as prototypes for rows in queries. */
  class Stastationtypes(_tableTag: Tag) extends Table[StastationtypesRow](_tableTag, Some("dbo"), "staStationTypes") {
    def * = (stationtypeid, dockentryx, dockentryy, dockentryz, dockorientationx, dockorientationy, dockorientationz, operationid, officeslots, reprocessingefficiency, conquerable) <> (StastationtypesRow.tupled, StastationtypesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (stationtypeid.?, dockentryx, dockentryy, dockentryz, dockorientationx, dockorientationy, dockorientationz, operationid, officeslots, reprocessingefficiency, conquerable).shaped.<>({r=>import r._; _1.map(_=> StastationtypesRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column stationTypeID DBType(int), PrimaryKey */
    val stationtypeid: Column[Int] = column[Int]("stationTypeID", O.PrimaryKey)
    /** Database column dockEntryX DBType(float) */
    val dockentryx: Column[Option[Double]] = column[Option[Double]]("dockEntryX")
    /** Database column dockEntryY DBType(float) */
    val dockentryy: Column[Option[Double]] = column[Option[Double]]("dockEntryY")
    /** Database column dockEntryZ DBType(float) */
    val dockentryz: Column[Option[Double]] = column[Option[Double]]("dockEntryZ")
    /** Database column dockOrientationX DBType(float) */
    val dockorientationx: Column[Option[Double]] = column[Option[Double]]("dockOrientationX")
    /** Database column dockOrientationY DBType(float) */
    val dockorientationy: Column[Option[Double]] = column[Option[Double]]("dockOrientationY")
    /** Database column dockOrientationZ DBType(float) */
    val dockorientationz: Column[Option[Double]] = column[Option[Double]]("dockOrientationZ")
    /** Database column operationID DBType(tinyint) */
    val operationid: Column[Option[Byte]] = column[Option[Byte]]("operationID")
    /** Database column officeSlots DBType(tinyint) */
    val officeslots: Column[Option[Byte]] = column[Option[Byte]]("officeSlots")
    /** Database column reprocessingEfficiency DBType(float) */
    val reprocessingefficiency: Column[Option[Double]] = column[Option[Double]]("reprocessingEfficiency")
    /** Database column conquerable DBType(bit) */
    val conquerable: Column[Option[Boolean]] = column[Option[Boolean]]("conquerable")
  }
  /** Collection-like TableQuery object for table Stastationtypes */
  lazy val Stastationtypes = new TableQuery(tag => new Stastationtypes(tag))
  
  /** Entity class storing rows of table TraceXeActionMap
   *  @param traceColumnId Database column trace_column_id DBType(smallint)
   *  @param packageName Database column package_name DBType(nvarchar), Length(60,true)
   *  @param xeActionName Database column xe_action_name DBType(nvarchar), Length(60,true) */
  case class TraceXeActionMapRow(traceColumnId: Short, packageName: String, xeActionName: String)
  /** GetResult implicit for fetching TraceXeActionMapRow objects using plain SQL queries */
  implicit def GetResultTraceXeActionMapRow(implicit e0: GR[Short], e1: GR[String]): GR[TraceXeActionMapRow] = GR{
    prs => import prs._
    TraceXeActionMapRow.tupled((<<[Short], <<[String], <<[String]))
  }
  /** Table description of table trace_xe_action_map. Objects of this class serve as prototypes for rows in queries. */
  class TraceXeActionMap(_tableTag: Tag) extends Table[TraceXeActionMapRow](_tableTag, Some("sys"), "trace_xe_action_map") {
    def * = (traceColumnId, packageName, xeActionName) <> (TraceXeActionMapRow.tupled, TraceXeActionMapRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (traceColumnId.?, packageName.?, xeActionName.?).shaped.<>({r=>import r._; _1.map(_=> TraceXeActionMapRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column trace_column_id DBType(smallint) */
    val traceColumnId: Column[Short] = column[Short]("trace_column_id")
    /** Database column package_name DBType(nvarchar), Length(60,true) */
    val packageName: Column[String] = column[String]("package_name", O.Length(60,varying=true))
    /** Database column xe_action_name DBType(nvarchar), Length(60,true) */
    val xeActionName: Column[String] = column[String]("xe_action_name", O.Length(60,varying=true))
  }
  /** Collection-like TableQuery object for table TraceXeActionMap */
  lazy val TraceXeActionMap = new TableQuery(tag => new TraceXeActionMap(tag))
  
  /** Entity class storing rows of table TraceXeEventMap
   *  @param traceEventId Database column trace_event_id DBType(smallint)
   *  @param packageName Database column package_name DBType(nvarchar), Length(60,true)
   *  @param xeEventName Database column xe_event_name DBType(nvarchar), Length(60,true) */
  case class TraceXeEventMapRow(traceEventId: Short, packageName: String, xeEventName: String)
  /** GetResult implicit for fetching TraceXeEventMapRow objects using plain SQL queries */
  implicit def GetResultTraceXeEventMapRow(implicit e0: GR[Short], e1: GR[String]): GR[TraceXeEventMapRow] = GR{
    prs => import prs._
    TraceXeEventMapRow.tupled((<<[Short], <<[String], <<[String]))
  }
  /** Table description of table trace_xe_event_map. Objects of this class serve as prototypes for rows in queries. */
  class TraceXeEventMap(_tableTag: Tag) extends Table[TraceXeEventMapRow](_tableTag, Some("sys"), "trace_xe_event_map") {
    def * = (traceEventId, packageName, xeEventName) <> (TraceXeEventMapRow.tupled, TraceXeEventMapRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (traceEventId.?, packageName.?, xeEventName.?).shaped.<>({r=>import r._; _1.map(_=> TraceXeEventMapRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column trace_event_id DBType(smallint) */
    val traceEventId: Column[Short] = column[Short]("trace_event_id")
    /** Database column package_name DBType(nvarchar), Length(60,true) */
    val packageName: Column[String] = column[String]("package_name", O.Length(60,varying=true))
    /** Database column xe_event_name DBType(nvarchar), Length(60,true) */
    val xeEventName: Column[String] = column[String]("xe_event_name", O.Length(60,varying=true))
  }
  /** Collection-like TableQuery object for table TraceXeEventMap */
  lazy val TraceXeEventMap = new TableQuery(tag => new TraceXeEventMap(tag))
  
  /** Entity class storing rows of table Translationtables
   *  @param sourcetable Database column sourceTable DBType(nvarchar), Length(200,true)
   *  @param destinationtable Database column destinationTable DBType(nvarchar), Length(200,true)
   *  @param translatedkey Database column translatedKey DBType(nvarchar), Length(200,true)
   *  @param tcgroupid Database column tcGroupID DBType(int)
   *  @param tcid Database column tcID DBType(int) */
  case class TranslationtablesRow(sourcetable: String, destinationtable: Option[String], translatedkey: String, tcgroupid: Option[Int], tcid: Option[Int])
  /** GetResult implicit for fetching TranslationtablesRow objects using plain SQL queries */
  implicit def GetResultTranslationtablesRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[Option[Int]]): GR[TranslationtablesRow] = GR{
    prs => import prs._
    TranslationtablesRow.tupled((<<[String], <<?[String], <<[String], <<?[Int], <<?[Int]))
  }
  /** Table description of table translationTables. Objects of this class serve as prototypes for rows in queries. */
  class Translationtables(_tableTag: Tag) extends Table[TranslationtablesRow](_tableTag, Some("dbo"), "translationTables") {
    def * = (sourcetable, destinationtable, translatedkey, tcgroupid, tcid) <> (TranslationtablesRow.tupled, TranslationtablesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (sourcetable.?, destinationtable, translatedkey.?, tcgroupid, tcid).shaped.<>({r=>import r._; _1.map(_=> TranslationtablesRow.tupled((_1.get, _2, _3.get, _4, _5)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column sourceTable DBType(nvarchar), Length(200,true) */
    val sourcetable: Column[String] = column[String]("sourceTable", O.Length(200,varying=true))
    /** Database column destinationTable DBType(nvarchar), Length(200,true) */
    val destinationtable: Column[Option[String]] = column[Option[String]]("destinationTable", O.Length(200,varying=true))
    /** Database column translatedKey DBType(nvarchar), Length(200,true) */
    val translatedkey: Column[String] = column[String]("translatedKey", O.Length(200,varying=true))
    /** Database column tcGroupID DBType(int) */
    val tcgroupid: Column[Option[Int]] = column[Option[Int]]("tcGroupID")
    /** Database column tcID DBType(int) */
    val tcid: Column[Option[Int]] = column[Option[Int]]("tcID")
    
    /** Primary key of Translationtables (database name translationTables_PK) */
    val pk = primaryKey("translationTables_PK", (sourcetable, translatedkey))
  }
  /** Collection-like TableQuery object for table Translationtables */
  lazy val Translationtables = new TableQuery(tag => new Translationtables(tag))
  
  /** Entity class storing rows of table Trntranslationcolumns
   *  @param tcgroupid Database column tcGroupID DBType(smallint)
   *  @param tcid Database column tcID DBType(smallint), PrimaryKey
   *  @param tablename Database column tableName DBType(nvarchar), Length(256,true)
   *  @param columnname Database column columnName DBType(nvarchar), Length(128,true)
   *  @param masterid Database column masterID DBType(nvarchar), Length(128,true) */
  case class TrntranslationcolumnsRow(tcgroupid: Option[Short], tcid: Short, tablename: String, columnname: String, masterid: Option[String])
  /** GetResult implicit for fetching TrntranslationcolumnsRow objects using plain SQL queries */
  implicit def GetResultTrntranslationcolumnsRow(implicit e0: GR[Option[Short]], e1: GR[Short], e2: GR[String], e3: GR[Option[String]]): GR[TrntranslationcolumnsRow] = GR{
    prs => import prs._
    TrntranslationcolumnsRow.tupled((<<?[Short], <<[Short], <<[String], <<[String], <<?[String]))
  }
  /** Table description of table trnTranslationColumns. Objects of this class serve as prototypes for rows in queries. */
  class Trntranslationcolumns(_tableTag: Tag) extends Table[TrntranslationcolumnsRow](_tableTag, Some("dbo"), "trnTranslationColumns") {
    def * = (tcgroupid, tcid, tablename, columnname, masterid) <> (TrntranslationcolumnsRow.tupled, TrntranslationcolumnsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (tcgroupid, tcid.?, tablename.?, columnname.?, masterid).shaped.<>({r=>import r._; _2.map(_=> TrntranslationcolumnsRow.tupled((_1, _2.get, _3.get, _4.get, _5)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column tcGroupID DBType(smallint) */
    val tcgroupid: Column[Option[Short]] = column[Option[Short]]("tcGroupID")
    /** Database column tcID DBType(smallint), PrimaryKey */
    val tcid: Column[Short] = column[Short]("tcID", O.PrimaryKey)
    /** Database column tableName DBType(nvarchar), Length(256,true) */
    val tablename: Column[String] = column[String]("tableName", O.Length(256,varying=true))
    /** Database column columnName DBType(nvarchar), Length(128,true) */
    val columnname: Column[String] = column[String]("columnName", O.Length(128,varying=true))
    /** Database column masterID DBType(nvarchar), Length(128,true) */
    val masterid: Column[Option[String]] = column[Option[String]]("masterID", O.Length(128,varying=true))
  }
  /** Collection-like TableQuery object for table Trntranslationcolumns */
  lazy val Trntranslationcolumns = new TableQuery(tag => new Trntranslationcolumns(tag))
  
  /** Entity class storing rows of table Trntranslationlanguages
   *  @param numericlanguageid Database column numericLanguageID DBType(int), PrimaryKey
   *  @param languageid Database column languageID DBType(varchar), Length(50,true)
   *  @param languagename Database column languageName DBType(nvarchar), Length(200,true) */
  case class TrntranslationlanguagesRow(numericlanguageid: Int, languageid: Option[String], languagename: Option[String])
  /** GetResult implicit for fetching TrntranslationlanguagesRow objects using plain SQL queries */
  implicit def GetResultTrntranslationlanguagesRow(implicit e0: GR[Int], e1: GR[Option[String]]): GR[TrntranslationlanguagesRow] = GR{
    prs => import prs._
    TrntranslationlanguagesRow.tupled((<<[Int], <<?[String], <<?[String]))
  }
  /** Table description of table trnTranslationLanguages. Objects of this class serve as prototypes for rows in queries. */
  class Trntranslationlanguages(_tableTag: Tag) extends Table[TrntranslationlanguagesRow](_tableTag, Some("dbo"), "trnTranslationLanguages") {
    def * = (numericlanguageid, languageid, languagename) <> (TrntranslationlanguagesRow.tupled, TrntranslationlanguagesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (numericlanguageid.?, languageid, languagename).shaped.<>({r=>import r._; _1.map(_=> TrntranslationlanguagesRow.tupled((_1.get, _2, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column numericLanguageID DBType(int), PrimaryKey */
    val numericlanguageid: Column[Int] = column[Int]("numericLanguageID", O.PrimaryKey)
    /** Database column languageID DBType(varchar), Length(50,true) */
    val languageid: Column[Option[String]] = column[Option[String]]("languageID", O.Length(50,varying=true))
    /** Database column languageName DBType(nvarchar), Length(200,true) */
    val languagename: Column[Option[String]] = column[Option[String]]("languageName", O.Length(200,varying=true))
  }
  /** Collection-like TableQuery object for table Trntranslationlanguages */
  lazy val Trntranslationlanguages = new TableQuery(tag => new Trntranslationlanguages(tag))
  
  /** Entity class storing rows of table Trntranslations
   *  @param tcid Database column tcID DBType(smallint)
   *  @param keyid Database column keyID DBType(int)
   *  @param languageid Database column languageID DBType(varchar), Length(50,true)
   *  @param text Database column text DBType(nvarchar) */
  case class TrntranslationsRow(tcid: Short, keyid: Int, languageid: String, text: java.sql.Clob)
  /** GetResult implicit for fetching TrntranslationsRow objects using plain SQL queries */
  implicit def GetResultTrntranslationsRow(implicit e0: GR[Short], e1: GR[Int], e2: GR[String], e3: GR[java.sql.Clob]): GR[TrntranslationsRow] = GR{
    prs => import prs._
    TrntranslationsRow.tupled((<<[Short], <<[Int], <<[String], <<[java.sql.Clob]))
  }
  /** Table description of table trnTranslations. Objects of this class serve as prototypes for rows in queries. */
  class Trntranslations(_tableTag: Tag) extends Table[TrntranslationsRow](_tableTag, Some("dbo"), "trnTranslations") {
    def * = (tcid, keyid, languageid, text) <> (TrntranslationsRow.tupled, TrntranslationsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (tcid.?, keyid.?, languageid.?, text.?).shaped.<>({r=>import r._; _1.map(_=> TrntranslationsRow.tupled((_1.get, _2.get, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column tcID DBType(smallint) */
    val tcid: Column[Short] = column[Short]("tcID")
    /** Database column keyID DBType(int) */
    val keyid: Column[Int] = column[Int]("keyID")
    /** Database column languageID DBType(varchar), Length(50,true) */
    val languageid: Column[String] = column[String]("languageID", O.Length(50,varying=true))
    /** Database column text DBType(nvarchar) */
    val text: Column[java.sql.Clob] = column[java.sql.Clob]("text")
    
    /** Primary key of Trntranslations (database name trnTranslations_PK) */
    val pk = primaryKey("trnTranslations_PK", (tcid, keyid, languageid))
  }
  /** Collection-like TableQuery object for table Trntranslations */
  lazy val Trntranslations = new TableQuery(tag => new Trntranslations(tag))
  
  /** Entity class storing rows of table Warcombatzones
   *  @param combatzoneid Database column combatZoneID DBType(int), PrimaryKey
   *  @param combatzonename Database column combatZoneName DBType(nvarchar), Length(100,true)
   *  @param factionid Database column factionID DBType(int)
   *  @param centersystemid Database column centerSystemID DBType(int)
   *  @param description Database column description DBType(nvarchar), Length(500,true) */
  case class WarcombatzonesRow(combatzoneid: Int, combatzonename: Option[String], factionid: Option[Int], centersystemid: Option[Int], description: Option[String])
  /** GetResult implicit for fetching WarcombatzonesRow objects using plain SQL queries */
  implicit def GetResultWarcombatzonesRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[Option[Int]]): GR[WarcombatzonesRow] = GR{
    prs => import prs._
    WarcombatzonesRow.tupled((<<[Int], <<?[String], <<?[Int], <<?[Int], <<?[String]))
  }
  /** Table description of table warCombatZones. Objects of this class serve as prototypes for rows in queries. */
  class Warcombatzones(_tableTag: Tag) extends Table[WarcombatzonesRow](_tableTag, Some("dbo"), "warCombatZones") {
    def * = (combatzoneid, combatzonename, factionid, centersystemid, description) <> (WarcombatzonesRow.tupled, WarcombatzonesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (combatzoneid.?, combatzonename, factionid, centersystemid, description).shaped.<>({r=>import r._; _1.map(_=> WarcombatzonesRow.tupled((_1.get, _2, _3, _4, _5)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column combatZoneID DBType(int), PrimaryKey */
    val combatzoneid: Column[Int] = column[Int]("combatZoneID", O.PrimaryKey)
    /** Database column combatZoneName DBType(nvarchar), Length(100,true) */
    val combatzonename: Column[Option[String]] = column[Option[String]]("combatZoneName", O.Length(100,varying=true))
    /** Database column factionID DBType(int) */
    val factionid: Column[Option[Int]] = column[Option[Int]]("factionID")
    /** Database column centerSystemID DBType(int) */
    val centersystemid: Column[Option[Int]] = column[Option[Int]]("centerSystemID")
    /** Database column description DBType(nvarchar), Length(500,true) */
    val description: Column[Option[String]] = column[Option[String]]("description", O.Length(500,varying=true))
  }
  /** Collection-like TableQuery object for table Warcombatzones */
  lazy val Warcombatzones = new TableQuery(tag => new Warcombatzones(tag))
  
  /** Entity class storing rows of table Warcombatzonesystems
   *  @param solarsystemid Database column solarSystemID DBType(int), PrimaryKey
   *  @param combatzoneid Database column combatZoneID DBType(int) */
  case class WarcombatzonesystemsRow(solarsystemid: Int, combatzoneid: Option[Int])
  /** GetResult implicit for fetching WarcombatzonesystemsRow objects using plain SQL queries */
  implicit def GetResultWarcombatzonesystemsRow(implicit e0: GR[Int], e1: GR[Option[Int]]): GR[WarcombatzonesystemsRow] = GR{
    prs => import prs._
    WarcombatzonesystemsRow.tupled((<<[Int], <<?[Int]))
  }
  /** Table description of table warCombatZoneSystems. Objects of this class serve as prototypes for rows in queries. */
  class Warcombatzonesystems(_tableTag: Tag) extends Table[WarcombatzonesystemsRow](_tableTag, Some("dbo"), "warCombatZoneSystems") {
    def * = (solarsystemid, combatzoneid) <> (WarcombatzonesystemsRow.tupled, WarcombatzonesystemsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (solarsystemid.?, combatzoneid).shaped.<>({r=>import r._; _1.map(_=> WarcombatzonesystemsRow.tupled((_1.get, _2)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column solarSystemID DBType(int), PrimaryKey */
    val solarsystemid: Column[Int] = column[Int]("solarSystemID", O.PrimaryKey)
    /** Database column combatZoneID DBType(int) */
    val combatzoneid: Column[Option[Int]] = column[Option[Int]]("combatZoneID")
  }
  /** Collection-like TableQuery object for table Warcombatzonesystems */
  lazy val Warcombatzonesystems = new TableQuery(tag => new Warcombatzonesystems(tag))
}