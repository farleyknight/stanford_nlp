
import java.io._
import java.util._

import edu.stanford.nlp.ling._
import edu.stanford.nlp.tagger.maxent.MaxentTagger

object SentenceTagger {
  def main(args: Array[String]) {
    val tagger    = new MaxentTagger("models/english-bidirectional-distsim.tagger")
    val sentences = MaxentTagger.tokenizeText(new BufferedReader(new FileReader("text/sample.txt")))
    println(tagger.tagSentence(sentences.get(0)))
  }
}
