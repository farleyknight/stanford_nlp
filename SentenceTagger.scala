import java.io._
import java.util._

import edu.stanford.nlp.ling._
import edu.stanford.nlp.tagger.maxent.MaxentTagger

import edu.stanford.nlp.ie._
import edu.stanford.nlp.ie.crf._
import edu.stanford.nlp.io.IOUtils
import edu.stanford.nlp.ling._


object SentenceTagger {
  def main2(args: Array[String]) {
    val tagger    = new MaxentTagger("models/english-bidirectional-distsim.tagger")
    val sentences = MaxentTagger.tokenizeText(new BufferedReader(new FileReader("text/sample.txt")))
    println(tagger.tagSentence(sentences.get(0)))
  }
}

object EntityTagger {
  def main(args: Array[String]) {
    val serializedClassifier = "classifiers/english.all.3class.distsim.crf.ser.gz"
    val classifier           = CRFClassifier.getClassifierNoExceptions(serializedClassifier)
    val s1                   = "Good afternoon Farley Knight, how are you today?"
    val s                    = new Scanner(new File("text/ner.sample4.txt")).useDelimiter("\\A").next()

    // println(classifier.classifyToString(s1))
    // println(classifier.classifyWithInlineXML(s1))
    println(classifier.classifyToString(s))
    println(classifier.classifyWithInlineXML(s))
  }
}
