package countAnnotator;

import static org.apache.uima.fit.util.JCasUtil.select;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import countAnnotator.type.CountAnnotation;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;

public class CountAnnotator extends JCasAnnotator_ImplBase {

	@Override
	public void process(JCas jCas) throws AnalysisEngineProcessException {
		//Die org.apache.uima.fit.util.JCasUtil.select Funktion ermoeglicht das selectieren
		//von Annotationsebenen aus dem uebergebenen JCas.
		//In diesem Beispiel werden die Tokens selectiert und ausgegeben.
		//Die Annotationsebenen finden sie hier: https://dkpro.github.io/dkpro-core/releases/1.7.0/typesystem/
		
		for (Token token : select(jCas,Token.class)) {
			//Ausgabe
			System.out.println(token.getCoveredText());
			System.out.println(token);
			
			
			//TestType ist eine weitere Annotations Ebene. Die Spezifikation von CountAnnotation kann unter
			// src/main/resources/desc/type/CountAnnotationTypeSystem.xml gefunden werden.
			//
			//Jede Annotation muss ein "begin" und ein "end" haben, da JCas eine standoff-annotation.
			//Die Attribute der TestType Annotation muessen in der TestTypeSystem.xml definiert werden.
			CountAnnotation test = new CountAnnotation(jCas, token.getBegin(), token.getEnd());
			test.setValue("Hier kann ein text stehen."); 
			test.setCount(123);							
			test.addToIndexes();
		}
	}
}
