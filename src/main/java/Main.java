import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.cas.CASRuntimeException;
import org.apache.uima.fit.factory.JCasFactory;
import org.apache.uima.fit.pipeline.SimplePipeline;
import org.apache.uima.jcas.JCas;
import org.hucompute.services.util.XmlFormatter;

import countAnnotator.CountAnnotator;
import de.tudarmstadt.ukp.dkpro.core.languagetool.LanguageToolLemmatizer;
import de.tudarmstadt.ukp.dkpro.core.languagetool.LanguageToolSegmenter;
import de.tudarmstadt.ukp.dkpro.core.stanfordnlp.StanfordPosTagger;
import de.tudarmstadt.ukp.dkpro.core.tokit.ParagraphSplitter;

import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngineDescription;

import java.io.IOException;

import org.apache.uima.UIMAException;

public class Main {

	public static void main(String[] args) throws UIMAException, CASRuntimeException, IOException {
		//Segmentierer. Fuegt Token und Sentece Ebene hinzu.
		AnalysisEngineDescription segmenter = createEngineDescription(LanguageToolSegmenter.class);
		//Fuegt die Paragraph Annotationsebene hinzu.
		AnalysisEngineDescription paragraphtsplitter = createEngineDescription(ParagraphSplitter.class);
		//Pos-Tagger. Fuegt POS-Tag Ebene hinzu
		AnalysisEngineDescription pos = createEngineDescription(StanfordPosTagger.class);
		//Lemmatisierer. Fuegt Lemma Ebene hinzu.
		AnalysisEngineDescription lemmatizer = createEngineDescription(LanguageToolLemmatizer.class);

		
		
		//Ihr Annotator, der die statistischen Auswertungen dem XMI-Cas Objekt hinzufuegen soll.
		AnalysisEngineDescription countAnnotator = createEngineDescription(CountAnnotator.class);

		//JCas ist quasi die "Holder"-Klasse fuer die Annotationsebenen. 
		JCas inputCas = JCasFactory.createJCas();

		//Die Eingabesprache
		inputCas.setDocumentLanguage("de");

		//Der Eingabetext.
		inputCas.setDocumentText("Das ist ein simpler Test.");

		//File als eingabe.
//				inputCas.setDocumentText(FileUtils.readFileToString(new File("src/main/resources/kafka_verwandlung_kapitel_1.txt")));
		
		//Die pipeline. Die JCas wird von Annotator zu Annotator gereicht, und jeweils mit Ebenen
		//angereichert. Jeder Annotator kann auf die Annotationsebenen der Annotatoren zugreifen,
		//die zuvor in der Pipeline ausgefuert wurden.
		SimplePipeline.runPipeline(inputCas, segmenter,paragraphtsplitter,pos,lemmatizer,countAnnotator);

		//Ausgabe
		System.out.println(XmlFormatter.getPrettyString(inputCas.getCas()));
		
	}

}
