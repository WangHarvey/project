package com.unimelb.project.api;

import java.util.List;
import java.util.Properties;

import edu.stanford.nlp.ling.CoreAnnotations.LemmaAnnotation;
//import edu.stanford.nlp.ling.CoreAnnotations.NamedEntityTagAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
//import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

public class StanfordNLP {
	
	public static String getKeywords(String str){
		/**
         * Create a StanfordCoreNLP object
         * tokenize、ssplit、 pos、lemma、
         * ner、parse
         */

        Properties props = new Properties();
        props.put("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");    // seven Annotators
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);    // process one by one

        String keywords = "";
        Annotation document = new Annotation(str);    // create an empty Annotation using title
        pipeline.annotate(document);                   // processing title with all Annotators

        // all results
        List<CoreMap> sentences = document.get(SentencesAnnotation.class);

        for(CoreMap sentence: sentences) {
            for (CoreLabel token: sentence.get(TokensAnnotation.class)) {

//                String word = token.get(TextAnnotation.class);            
                String pos = token.get(PartOfSpeechAnnotation.class);     
//                String ne = token.get(NamedEntityTagAnnotation.class);    
                String lemma = token.get(LemmaAnnotation.class);          
                
                if(pos.equals("NNP") || pos.equals("NNPS") ){
                	keywords += lemma + " ";
                }
                
            }

        }
		return keywords;
	}

}
