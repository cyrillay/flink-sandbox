package lays.pro

import org.apache.flink.api.scala.{AggregateDataSet, DataSet, ExecutionEnvironment}
import org.apache.flink.streaming.api.scala._

object Job {

  def main(args: Array[String]): Unit = {
    val env: ExecutionEnvironment = ExecutionEnvironment.getExecutionEnvironment
    val text: DataSet[String] = env.readTextFile("/Users/cyril/test/test.log")

    val counts: AggregateDataSet[(String, Int)] =
      text.flatMap(
        _.toLowerCase.split("\\W+")
          .filter(_.nonEmpty)
      ).map((_, 1))
        .groupBy(0)
        .sum(1)

    counts.writeAsCsv("/Users/cyril/test/output-flink.log", "\n", " ")

    env.execute()
  }

}