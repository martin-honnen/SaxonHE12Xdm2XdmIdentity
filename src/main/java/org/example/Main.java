package org.example;

import net.sf.saxon.s9api.*;

import java.io.File;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SaxonApiException {

        Processor processor = new Processor();

        DocumentBuilder docBuilder = processor.newDocumentBuilder();

        XdmNode doc1 = docBuilder.build(new File("sample1.xml"));

        System.out.println(doc1.hashCode());

        XsltCompiler xsltCompiler = processor.newXsltCompiler();

        XsltExecutable xsltExecutable = xsltCompiler.compile(new File("adaptive-identity.xsl"));

        Xslt30Transformer xsltTransformer = xsltExecutable.load30();

        XdmNode resultDoc = (XdmNode)xsltTransformer.applyTemplates(doc1);

        System.out.println(resultDoc.hashCode());

        System.out.println(doc1.equals(resultDoc));
    }
}