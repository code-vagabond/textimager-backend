

/* First created by JCasGen Tue Apr 12 15:59:03 CEST 2016 */
package countAnnotator.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Tue Apr 12 15:59:03 CEST 2016
 * XML source: /home/ahemati/workspace/Fingeruebung/src/main/resources/desc/type/TestTypeSystem.xml
 * @generated */
public class CountAnnotation extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(CountAnnotation.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected CountAnnotation() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public CountAnnotation(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public CountAnnotation(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public CountAnnotation(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: value

  /** getter for value - gets start and end of the objects
   * @generated
   * @return value of the feature 
   */
  public String getValue() {
    if (CountAnnotation_Type.featOkTst && ((CountAnnotation_Type)jcasType).casFeat_value == null)
      jcasType.jcas.throwFeatMissing("value", "countAnnotator.type.CountAnnotation");
    return jcasType.ll_cas.ll_getStringValue(addr, ((CountAnnotation_Type)jcasType).casFeatCode_value);}
    
  /** setter for value - sets start and end of the objects 
   * @generated
   * @param v value to set into the feature 
   */
  public void setValue(String v) {
    if (CountAnnotation_Type.featOkTst && ((CountAnnotation_Type)jcasType).casFeat_value == null)
      jcasType.jcas.throwFeatMissing("value", "countAnnotator.type.CountAnnotation");
    jcasType.ll_cas.ll_setStringValue(addr, ((CountAnnotation_Type)jcasType).casFeatCode_value, v);}    
   
    
  //*--------------*
  //* Feature: count

  /** getter for count - gets 
   * @generated
   * @return value of the feature 
   */
  public int getCount() {
    if (CountAnnotation_Type.featOkTst && ((CountAnnotation_Type)jcasType).casFeat_count == null)
      jcasType.jcas.throwFeatMissing("count", "countAnnotator.type.CountAnnotation");
    return jcasType.ll_cas.ll_getIntValue(addr, ((CountAnnotation_Type)jcasType).casFeatCode_count);}
    
  /** setter for count - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setCount(int v) {
    if (CountAnnotation_Type.featOkTst && ((CountAnnotation_Type)jcasType).casFeat_count == null)
      jcasType.jcas.throwFeatMissing("count", "countAnnotator.type.CountAnnotation");
    jcasType.ll_cas.ll_setIntValue(addr, ((CountAnnotation_Type)jcasType).casFeatCode_count, v);}    
  }

    