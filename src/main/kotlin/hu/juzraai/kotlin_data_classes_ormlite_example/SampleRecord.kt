package hu.juzraai.kotlin_data_classes_ormlite_example

import com.j256.ormlite.field.DatabaseField
import com.j256.ormlite.table.DatabaseTable
import java.util.*

/**
 * @author Zsolt Jurányi
 */
@DatabaseTable(tableName = "sample_table")
data class SampleRecord(
		@DatabaseField(id = true)
		var id: String? = null,

		@DatabaseField(canBeNull = false)
		var numField: Int? = null,

		@DatabaseField
		var strField: String = "",

		@DatabaseField
		var timestamp: Date = Date()
)