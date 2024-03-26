package br.fintrack.repositories;

import br.fintrack.models.Movimentacao;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MovimentacaoRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;


    public Movimentacao save(Movimentacao movimentacao) {
        dynamoDBMapper.save(movimentacao);
        return movimentacao;
    }

    public Movimentacao getMovimentacaoById(Short movimentacaoId) {
        return dynamoDBMapper.load(Movimentacao.class, movimentacaoId);
    }

    public String delete(Short movimentacaoId) {
        Movimentacao m = dynamoDBMapper.load(Movimentacao.class, movimentacaoId);
        dynamoDBMapper.delete(m);
        return "Movimentacao Deleted!";
    }

    public Short update(Short movimentacaoId, Movimentacao movimentacao) {
        dynamoDBMapper.save(movimentacao,
                new DynamoDBSaveExpression()
                        .withExpectedEntry("movimentacaoId",
                                new ExpectedAttributeValue(
                                        new AttributeValue().withS(String.valueOf(movimentacaoId))
                                )));
        return movimentacaoId;
    }
}