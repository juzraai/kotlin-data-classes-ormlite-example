package hu.juzraai.kotlin_data_classes_ormlite_example

import com.j256.ormlite.dao.Dao
import com.j256.ormlite.dao.DaoManager
import com.j256.ormlite.jdbc.JdbcConnectionSource
import com.j256.ormlite.table.TableUtils
import java.util.*

/**
 * @author Zsolt Jurányi
 */
fun main(args: Array<String>) {

	// init database connection
	val databaseFilename = "sample.db"
	val connectionString = "jdbc:sqlite:$databaseFilename"
	val connectionSource = JdbcConnectionSource(connectionString)
	val dao = DaoManager.createDao(connectionSource, SampleRecord::class.java) as Dao<SampleRecord, String>

	// create table
	TableUtils.createTableIfNotExists(connectionSource, SampleRecord::class.java)

	// save dummy data
	val num = Random().nextInt(3)
	dao.createOrUpdate(SampleRecord("id-$num", num, "Hello!"))

	// query data by id
	for (i in 0..2) {
		val record = dao.queryForId("id-$i")
		println("Query for ID 'id-$i': $record")
	}

	// query all data
	dao.forEach { record -> println("Query for all: $record") }

	// close connection
	connectionSource.closeQuietly()
}
