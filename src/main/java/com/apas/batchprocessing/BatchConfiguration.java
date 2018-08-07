/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apas.batchprocessing;

import com.apas.model.User;
import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
//import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

/**
 *
 * @author ekaranja
 */
@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Bean
    public Job load(JobBuilderFactory jobBuilderFactory,
            StepBuilderFactory stepBuilderFactory,
            ItemReader<User> itemReader,
            ItemProcessor<User, User> itemProcessor,
            ItemWriter<User> itemWriter
    ) {

        Step step = stepBuilderFactory.get("Etl-File-Load")
                .<User, User> chunk(100)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();

        return jobBuilderFactory.get("load")
                .incrementer(new RunIdIncrementer())
                .start(step)
                .build();

    }
    
    
    
    
    
       @Bean
    public Job load2(JobBuilderFactory jobBuilderFactory,
            StepBuilderFactory stepBuilderFactory,
            ItemReader<User> itemReader2,
            ItemProcessor<User, User> itemProcessor2,
            ItemWriter<User> itemWriter2
    ) {

        Step step = stepBuilderFactory.get("Etl-File-Load2")
                .<User, User> chunk(100)
                .reader(itemReader2)
                .processor(itemProcessor2)
                .writer(itemWriter2)
                .build();

        return jobBuilderFactory.get("load2")
                .incrementer(new RunIdIncrementer())
                .start(step)
                .build();

    }
    
    
      @Bean
    public FlatFileItemReader<User> itemReader() {

        FlatFileItemReader<User> flatFileItemReader = new FlatFileItemReader<>();
        flatFileItemReader.setResource(new ClassPathResource("users.csv"));
        flatFileItemReader.setName("CSV-Reader");
        flatFileItemReader.setLinesToSkip(1);
        flatFileItemReader.setLineMapper(lineMapper());
        return flatFileItemReader;
}
    
       @Bean
    public LineMapper<User> lineMapper() {

        DefaultLineMapper<User> defaultLineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames(new String[]{"id", "name", "dept", "salary"});

        BeanWrapperFieldSetMapper<User> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(User.class);

        defaultLineMapper.setLineTokenizer(lineTokenizer);
        defaultLineMapper.setFieldSetMapper(fieldSetMapper);

        return defaultLineMapper;
}
    
    
      @Bean
    public FlatFileItemReader<User> itemReader2() {

        FlatFileItemReader<User> flatFileItemReader = new FlatFileItemReader<>();
        flatFileItemReader.setResource(new ClassPathResource("users2.csv"));
        flatFileItemReader.setName("CSV-Reader");
        flatFileItemReader.setLinesToSkip(1);
        flatFileItemReader.setLineMapper(lineMapper());
        return flatFileItemReader;
}
    
       @Bean
    public LineMapper<User> lineMapper2() {

        DefaultLineMapper<User> defaultLineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames(new String[]{"id", "name", "dept", "salary"});

        BeanWrapperFieldSetMapper<User> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(User.class);

        defaultLineMapper.setLineTokenizer(lineTokenizer);
        defaultLineMapper.setFieldSetMapper(fieldSetMapper);

        return defaultLineMapper;
}

//     @Autowired
//    public JobBuilderFactory jobBuilderFactory;
//     
//     @Autowired
//    public StepBuilderFactory stepBuilderFactory;
//     
//        @Bean
//    public FlatFileItemReader<Person> reader() throws Exception {
//        return new FlatFileItemReaderBuilder<Person>()
//            .name("personItemReader")
////            .resource(new ClassPathResource("sample-data.csv"))
//               .resource(new FileSystemResource("/home/ekaranja/Music/pas/sample-data.csv"))
//            .delimited()
//            .names(new String[]{"firstName", "lastName"})
//            .fieldSetMapper(new BeanWrapperFieldSetMapper<Person>() {{
//                setTargetType(Person.class);
//            }})
//            .build();
//    }
//    
//       @Bean
//    public PersonItemProcessor processor() {
//        return new PersonItemProcessor();
//    }
//
//      @Bean
//    public JdbcBatchItemWriter<Person> writer(DataSource dataSource) {
//        return new JdbcBatchItemWriterBuilder<Person>()
//            .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
//            .sql("INSERT INTO people (first_name, last_name) VALUES (:firstName, :lastName)")
//            .dataSource(dataSource)
//            .build();
//    }
//    // end::readerwriterprocessor[]
//
//    // tag::jobstep[]
//        @Bean
//    public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
//        return jobBuilderFactory.get("importUserJob")
//            .incrementer(new RunIdIncrementer())
//            .listener(listener)
//            .flow(step1)
//            .end()
//            .build();
//    }
//
//    @Bean
//    public Step step1(JdbcBatchItemWriter<Person> writer) throws Exception {
//        return stepBuilderFactory.get("step1")
//            .<Person, Person> chunk(10)
//            .reader(reader())
//            .processor(processor())
//            .writer(writer)
//            .build();
//    }
//    // end::jobstep[]
}
